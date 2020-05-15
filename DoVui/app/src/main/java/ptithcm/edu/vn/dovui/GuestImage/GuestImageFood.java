package ptithcm.edu.vn.dovui.GuestImage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import ptithcm.edu.vn.dovui.MonAnActivity;
import ptithcm.edu.vn.dovui.R;

public class GuestImageFood extends AppCompatActivity {

    public List<String> suggestSource = new ArrayList<>();

    public quizadapter answerAdapter;
    public suguestadapter suggestAdapter;
    public int diem =0;
    public Button btnSubmit;
    TextView tvDiem;
    Intent intent;
    public GridView gridViewAnswer, gridViewSuggest;

    public ImageView imgViewQuestion;

    int[] image_list = {
            R.drawable.banhbo,
            R.drawable.banhyen,
            R.drawable.banhtam,
            R.drawable.banhkhot,
            R.drawable.banhbia,
            R.drawable.banhxeo,
            R.drawable.banhtet,
            R.drawable.cakhoto,
            R.drawable.duondua,
            R.drawable.bundaumamtom,
            R.drawable.banhcuon,
            R.drawable.chagio,
            R.drawable.banhchung,
            R.drawable.pho,
            R.drawable.hotvitlon,
            R.drawable.goicuon,
            R.drawable.balalot,
            R.drawable.banhcanh
    };

    public char[] answer;

    String correct_answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_food);
        intent = getIntent();
        diem = intent.getIntExtra("diem",0);
        tvDiem = (TextView) findViewById(R.id.tvdiem);
        //Init View
        initView();


    }

    private void initView() {
        gridViewAnswer = (GridView) findViewById(R.id.gridViewAnswer);
        gridViewSuggest = (GridView) findViewById(R.id.gridViewSuggest);
        imgViewQuestion = (ImageView) findViewById(R.id.imgLogo);
        //Add SetupList Here
        setupList();
        tvDiem.setText("Điểm của bé: "+diem);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = "";
                for (int i = 0; i < Common.user_submit_answer.length; i++)
                    result += String.valueOf(Common.user_submit_answer[i]);
                if (result.equals(correct_answer)) {
                    Toast.makeText(getApplicationContext(), "Finish ! This is " + result, Toast.LENGTH_SHORT).show();
                    diem +=100;
                    //Reset
                    Common.count = 0;
                    Common.user_submit_answer = new char[correct_answer.length()];

                    //Set Adapter
                    quizadapter answerAdapter = new quizadapter(setupNullList(), getApplicationContext());
                    gridViewAnswer.setAdapter(answerAdapter);
                    answerAdapter.notifyDataSetChanged();

                    suguestadapter suggestAdapter = new suguestadapter(suggestSource, getApplicationContext(), GuestImageFood.this);
                    gridViewSuggest.setAdapter(suggestAdapter);
                    suggestAdapter.notifyDataSetChanged();

                    Intent intent = new Intent(GuestImageFood.this, MonAnActivity.class);
                    intent.putExtra("diem",diem);
                    startActivity(intent);

                } else {
                    Toast.makeText(GuestImageFood.this, "Incorrect!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void setupList() {
        //Random logo
        Random random = new Random();
        int imageSelected = image_list[random.nextInt(image_list.length)];
        imgViewQuestion.setImageResource(imageSelected);

        correct_answer = getResources().getResourceName(imageSelected);
        correct_answer = correct_answer.substring(correct_answer.lastIndexOf("/") + 1);

        answer = correct_answer.toCharArray();

        Common.user_submit_answer = new char[answer.length];

        //Add Answer character to List
        suggestSource.clear();
        for (char item : answer) {
            //Add logo name to list
            suggestSource.add(String.valueOf(item));
        }

        //Random add some character to list
        for (int i = answer.length; i < answer.length * 2; i++)
            suggestSource.add(Common.alphabet_character[random.nextInt(Common.alphabet_character.length)]);

        //Sort random
        Collections.shuffle(suggestSource);

        //Set for GridView
        answerAdapter = new quizadapter(setupNullList(), this);
        suggestAdapter = new suguestadapter(suggestSource, this, this);

        answerAdapter.notifyDataSetChanged();
        suggestAdapter.notifyDataSetChanged();

        gridViewSuggest.setAdapter(suggestAdapter);
        gridViewAnswer.setAdapter(answerAdapter);


    }

    private char[] setupNullList() {
        char result[] = new char[answer.length];
        for (int i = 0; i < answer.length; i++)
            result[i] = ' ';
        return result;
    }
}
