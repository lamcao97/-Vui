package ptithcm.edu.vn.dovui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import ptithcm.edu.vn.dovui.Module.IQQuestion;
import ptithcm.edu.vn.dovui.Module.diem;

public class IQActivity extends AppCompatActivity implements View.OnClickListener {
    private int diem = 0;
    Button btn1, btn2, btn3, btn4, btndiem;
    TextView tv_cauhoi ;

    DBManager data, datadiem;
    private String answer;
    ArrayList<IQQuestion> arrch = new ArrayList<>();
    Random random;

    ArrayList<ptithcm.edu.vn.dovui.Module.diem> arrdiem = new ArrayList<>();
    int SLbe=0;


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_iq);

    datadiem = new DBManager(this, "diemso.db", null, 1);
    Cursor cursordiem = datadiem.TruyVanTraVe("Select * From Diem");
    while (cursordiem.moveToNext()){
        SLbe++;
    }

    // khai bao data
    data = new DBManager(this, "iq.db", null, 1);
    data.TruyVanKhongTraVe("Create Table If not exists IQ(MaCH Integer Primary Key Autoincrement ,cauhoi Varchar, traloi1 Varchar,traloi2 Varchar,traloi3 Varchar,traloi4 Varchar,traloidung Varchar,flag Integer)");

    Cursor cursor = data.TruyVanTraVe("Select * From IQ");
    while (cursor.moveToNext()) {
        arrch.add(new IQQuestion(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getInt(7)));
    }
    int sum = 0;
    for (IQQuestion element : arrch) {
        sum++;
    }
    if (sum == 0) {
        data.TruyVanKhongTraVe("Insert into IQ values (null, 'Điền vào số tiếp theo: 3, 5, 9, ... : ','"+10+"','"+11+"','"+12+"','"+13+"','"+13+"', 0)");
        data.TruyVanKhongTraVe("Insert into IQ values (null, '1+1+1+0 = ? ','"+0+"','"+1+"','"+2+"','"+3+"','"+3+"', 0)");
        data.TruyVanKhongTraVe("Insert into IQ values (null, '"+1+"+"+4+"="+10+", "+2+"+"+8+"="+20+", "+4+"+"+16+"=? : ','"+10+"','"+20+"','"+30+"','"+40+"','"+40+"', 0)");
        data.TruyVanKhongTraVe("Insert into IQ values (null, 'Ai là vợ của bố ? ','Cháu','Ông','Dì','Mẹ','Mẹ', 0)");
        data.TruyVanKhongTraVe("Insert into IQ values (null, 'Cây xanh nhờ đâu ?','Diệp lục','Ánh sáng','Chuột','Mèo','Ánh sáng', 0)");
        data.TruyVanKhongTraVe("Insert into IQ values (null, 'Một năm có bao nhiêu tháng ?','"+10+"','"+11+"','"+12+"','"+13+"','"+12+"', 0)");
        data.TruyVanKhongTraVe("Insert into IQ values (null, 'Tháng 2 có bao nhiêu ngày ?','"+10+"','"+12+"','"+18+"','"+28+"','"+28+"', 0)");
        data.TruyVanKhongTraVe("Insert into IQ values (null, 'Một Phút có 60s, 2 phút = bao nhiêu (s)','"+60+"','"+120+"','"+150+"','"+180+"','"+120+"', 0)");
        data.TruyVanKhongTraVe("Insert into IQ values (null, 'Một ngày bao nhiêu h ? ','"+12+"','"+24+"','"+13+"','"+25+"','"+24+"', 0)");
        data.TruyVanKhongTraVe("Insert into IQ values (null, 'Một tuần có bao nhiêu ngày ?','"+7+"','"+8+"','"+9+"','"+10+"','"+7+"', 0)");
        while (cursor.moveToNext()) {
            arrch.add(new IQQuestion(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getInt(7)));
        }
    }
    random = new Random();

    btn1 = findViewById(R.id.btn1);
    btn1.setOnClickListener(this);

    btn2 = findViewById(R.id.btn2);
    btn2.setOnClickListener(this);

    btn3 = findViewById(R.id.btn3);
    btn3.setOnClickListener(this);

    btn4 = findViewById(R.id.btn4);
    btn4.setOnClickListener(this);

    tv_cauhoi = findViewById(R.id.tv_cauhoi);
    tv_cauhoi.setOnClickListener(this);


    btndiem = (Button) findViewById(R.id.btndiem);
    btndiem.setOnClickListener(this);
    int rd = random.nextInt(arrch.size());
    NextQuestion(rd);
}

    @Override
    public void onClick(View v) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

        switch (v.getId()) {
            case R.id.btn1:

                alertDialog.setTitle("Thông báo");
                alertDialog.setIcon(R.drawable.chamhoi);
                alertDialog.setMessage("Đây là câu trả lời cuối cùng của bạn ?");

                alertDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if (btn1.getText().equals(answer)) {
                            diem = diem + 100;
                            Toast.makeText(IQActivity.this, "Chính Xác", Toast.LENGTH_SHORT).show();
                            int rd = random.nextInt(arrch.size());

                            NextQuestion(rd);
                        } else {
                            GameOver();
                        }

                    }
                });
                alertDialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                alertDialog.show();

                break;

            case R.id.btn2:
                alertDialog.setTitle("Thông báo");
                alertDialog.setIcon(R.drawable.chamhoi);
                alertDialog.setMessage("Đây là câu trả lời cuối cùng của bạn ?");

                alertDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if (btn2.getText().equals(answer)) {
                            diem = diem + 100;
                            Toast.makeText(IQActivity.this, "Chính Xác", Toast.LENGTH_SHORT).show();
                            int rd = random.nextInt(arrch.size());

                            NextQuestion(rd);
                        } else {
                            GameOver();
                        }

                    }
                });
                alertDialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                alertDialog.show();

                break;

            case R.id.btn3:
                alertDialog.setTitle("Thông báo");
                alertDialog.setIcon(R.drawable.chamhoi);
                alertDialog.setMessage("Đây là câu trả lời cuối cùng của bạn ?");

                alertDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if (btn3.getText().equals(answer)) {
                            diem = diem + 100;
                            Toast.makeText(IQActivity.this, "Chính Xác", Toast.LENGTH_SHORT).show();
                            int rd = random.nextInt(arrch.size());

                            NextQuestion(rd);
                        } else {
                            GameOver();
                        }

                    }
                });
                alertDialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                alertDialog.show();

                break;

            case R.id.btn4:
                alertDialog.setTitle("Thông báo");
                alertDialog.setIcon(R.drawable.chamhoi);
                alertDialog.setMessage("Đây là câu trả lời cuối cùng của bạn ?");

                alertDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if (btn4.getText().equals(answer)) {
                            diem = diem + 100;
                            Toast.makeText(IQActivity.this, "Chính Xác", Toast.LENGTH_SHORT).show();
                            int rd = random.nextInt(arrch.size());

                            NextQuestion(rd);
                        } else {
                            GameOver();
                        }

                    }
                });
                alertDialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                alertDialog.show();

                break;
        }

    }



    private void GameOver(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(IQActivity.this);
        alertDialogBuilder
                .setMessage("Bé đã trả lời sai rồi nè!")
                .setCancelable(false)
                .setPositiveButton("Bé có muốn chơi lại không?", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(getApplicationContext(), IQActivity.class));
                    }
                })
                .setNegativeButton("Thoát", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.exit(0);
                    }
                });
        alertDialogBuilder.show();
        datadiem.TruyVanKhongTraVe("UPDATE Diem set DiemIQ='"+diem+"' WHERE MaDiem='"+SLbe+"'");

    }


    private void NextQuestion(int i){
        IQQuestion dv = arrch.get(i);

        tv_cauhoi.setText(dv.getCauhoi());
        btn1.setText(dv.getTraloi1());
        btn2.setText(dv.getTraloi2());
        btn3.setText(dv.getTraloi3());
        btn4.setText(dv.getTraloi4());


       btndiem.setText("Điểm của bé: "+diem);

        answer = dv.getTraloidung();
    }
}





