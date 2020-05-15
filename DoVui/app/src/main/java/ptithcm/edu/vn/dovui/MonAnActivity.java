package ptithcm.edu.vn.dovui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import ptithcm.edu.vn.dovui.AnimationEnd.RewindActivity;
import ptithcm.edu.vn.dovui.GuestImage.GuestImageFood;
import ptithcm.edu.vn.dovui.Module.MonAnQuestion;

public class MonAnActivity extends AppCompatActivity implements View.OnClickListener {
    private int diem = 0;
    static int n = 0;
    int SLbe = 0;

    RadioButton btna, btnb, btnc, btnd;
    Button btnChange, btndiem;
    ImageView image;
    DBManager data, datadiem;
    private String answer;
    ArrayList<MonAnQuestion> arrch = new ArrayList<>();
    Random random;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monan);

        datadiem = new DBManager(this, "diemso.db", null, 1);
        Cursor cursordiem = datadiem.TruyVanTraVe("Select * From Diem");
        while (cursordiem.moveToNext()) {
            SLbe++;
        }
        data = new DBManager(this, "foody.db", null, 1);
        data.TruyVanKhongTraVe("Create Table If not exists Food(MaCH Integer Primary Key Autoincrement ,traloiA Varchar,traloiB Varchar,traloiC Varchar,traloiD Varchar,traloi Varchar)");

        Cursor cursor = data.TruyVanTraVe("Select * From Food");
        while (cursor.moveToNext()) {
            arrch.add(new MonAnQuestion(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5)));
        }
        int sum = 0;
        for (MonAnQuestion element : arrch) {
            sum++;
        }

        if (sum == 0) {
            data.TruyVanKhongTraVe("Insert into Food values (null, 'Bánh bò', 'Bánh tiêu', 'Bánh bao', 'Bánh mì', 'Bánh bò')");
            data.TruyVanKhongTraVe("Insert into Food values (null, 'Bánh yến', 'Bánh tiêu', 'Bánh bía', 'Bánh chuối', 'Bánh yến')");

            data.TruyVanKhongTraVe("Insert into Food values (null, 'Bánh bía', 'Bánh tằm', 'Bánh chuối', 'Bánh dừa', 'Bánh tằm')");
            data.TruyVanKhongTraVe("Insert into Food values (null, 'Bánh bèo', 'Bánh xèo', 'Bánh khọt', 'Bánh bía', 'Bánh khọt')");
            data.TruyVanKhongTraVe("Insert into Food values (null, 'Bánh cuốn', 'Bánh tiêu', 'Bánh bao', 'Bánh bía', 'Bánh bía')");
            data.TruyVanKhongTraVe("Insert into Food values (null, 'Bánh xèo', 'Bánh khọt', 'Bánh bao', 'Bánh tiêu', 'Bánh xèo')");

            data.TruyVanKhongTraVe("Insert into Food values (null, 'Bánh chưng', 'Bánh tét', 'Bánh dừa', 'Bánh tiêu', 'Bánh tét')");
            data.TruyVanKhongTraVe("Insert into Food values (null, 'Cá chiên', 'Cá hấp', 'Cá kho tộ', 'Thịt kho', 'Cá kho tộ')");
            data.TruyVanKhongTraVe("Insert into Food values (null, 'Bánh đúc', 'Cá bóng', 'Bánh chuối', 'Đuôn dừa', 'Đuôn dừa')");
            data.TruyVanKhongTraVe("Insert into Food values (null, 'Thịt nguội', 'Bún đậu mắm tôm', 'Bún mắm', 'Bún thịt nướng', 'Bún đậu mắm tôm')");

            data.TruyVanKhongTraVe("Insert into Food values (null, 'Bánh bò', 'Bánh tiêu', 'Bánh cuốn', 'Bánh mì', 'Bánh cuốn')");
            data.TruyVanKhongTraVe("Insert into Food values (null, 'Nem nướng', 'Bò lá lốt', 'Thịt nướng', 'Chả giò', 'Chả giò')");
            data.TruyVanKhongTraVe("Insert into Food values (null, 'Bánh chưng', 'Bánh tét', 'Bánh bía', 'Bánh mì', 'Bánh chưng')");
            data.TruyVanKhongTraVe("Insert into Food values (null, 'Bánh canh', 'Phở', 'Bún bò', 'Bún riêu', 'Phở')");
            data.TruyVanKhongTraVe("Insert into Food values (null, 'Trứng gà luộc', 'Trứng vịt luộc', 'Hột vịt lộn', 'Bánh mì', 'Hột vịt lộn')");

            data.TruyVanKhongTraVe("Insert into Food values (null, 'Bánh ướt', 'Chả giò', 'Bánh cuốn', 'Gỏi cuốn', 'Gỏi cuốn')");
            data.TruyVanKhongTraVe("Insert into Food values (null, 'Nem nướng', 'Bò lá lốt', 'Chả giò', 'Thịt nướng', 'Bò lá lốt')");
            data.TruyVanKhongTraVe("Insert into Food values (null, 'Phở', 'Bún bò', 'Bánh canh', 'Nui', 'Bánh canh')");


            while (cursor.moveToNext()) {
                arrch.add(new MonAnQuestion(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5)));
            }
        }


        random = new Random();
        init();
        int rd = random.nextInt(arrch.size());

        NextQuestion(rd);

    }

    public void init() {
        btna = findViewById(R.id.dapana);
        btna.setOnClickListener(this);

        btnb = findViewById(R.id.dapanb);
        btnb.setOnClickListener(this);

        btnc = findViewById(R.id.dapanc);
        btnc.setOnClickListener(this);

        btnd = findViewById(R.id.dapand);
        btnd.setOnClickListener(this);

        image = (ImageView) findViewById(R.id.tvv_imagequestion);
        image.setOnClickListener(this);

        btndiem = (Button) findViewById(R.id.btndiem);

        Intent intent = getIntent();
        diem = intent.getIntExtra("diem", diem);

        btndiem = (Button) findViewById(R.id.btndiem);
        btndiem.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        switch (v.getId()) {
            case R.id.dapana:

                alertDialog.setTitle("Thông báo");
                alertDialog.setIcon(R.drawable.chamhoi);
                alertDialog.setMessage("Đây là câu trả lời cuối cùng của bé ?");

                alertDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (btna.getText().equals(answer)) {
                            Toast.makeText(MonAnActivity.this, "Chính Xác", Toast.LENGTH_SHORT).show();
                            int rd = random.nextInt(arrch.size());
                            diem = diem + 100;
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

            case R.id.dapanb:
                alertDialog.setTitle("Thông báo");
                alertDialog.setIcon(R.drawable.chamhoi);
                alertDialog.setMessage("Đây là câu trả lời cuối cùng của bé ?");

                alertDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if (btnb.getText().equals(answer)) {
                            diem = diem + 100;
                            Toast.makeText(MonAnActivity.this, "Chính Xác", Toast.LENGTH_SHORT).show();
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

            case R.id.dapanc:
                alertDialog.setTitle("Thông báo");
                alertDialog.setIcon(R.drawable.chamhoi);
                alertDialog.setMessage("Đây là câu trả lời cuối cùng của bé ?");

                alertDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if (btnc.getText().equals(answer)) {
                            diem = diem + 100;
                            Toast.makeText(MonAnActivity.this, "Chính Xác", Toast.LENGTH_SHORT).show();
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

            case R.id.dapand:
                alertDialog.setTitle("Thông báo");
                alertDialog.setIcon(R.drawable.chamhoi);
                alertDialog.setMessage("Đây là câu trả lời cuối cùng của bé ?");

                alertDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if (btnd.getText().equals(answer)) {
                            diem = diem + 100;
                            Toast.makeText(MonAnActivity.this, "Chính Xác", Toast.LENGTH_SHORT).show();
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


    private void GameOver() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MonAnActivity.this);
        alertDialogBuilder
                .setMessage("Bé đã trả lời sai rồi\n Số điểm của bé: " + diem)
                .setCancelable(false)
                .setPositiveButton("Chơi Lại", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(getApplicationContext(), MonAnActivity.class));
                    }
                })
                .setNegativeButton("Thoát", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(getApplicationContext(), ChudeActivity.class));
                    }
                });
        alertDialogBuilder.show();
        datadiem.TruyVanKhongTraVe("UPDATE Diem set DiemMonAn='" + diem + "' WHERE MaDiem='" + SLbe + "'");

    }

    private void NextQuestion(int i) {
        if (n == 3 | n == 7) {
            Intent intent = new Intent(MonAnActivity.this, GuestImageFood.class);
            intent.putExtra("diem", diem);
            startActivity(intent);
        }
        if (n == 10){
            Intent intent = new Intent(MonAnActivity.this, RewindActivity.class);
            intent.putExtra("diem", diem);
            startActivity(intent);
        }
        n++;
        MonAnQuestion dv = arrch.get(i);
        btna.setText(dv.getTraloiA());
        btnb.setText(dv.getTraloiB());
        btnc.setText(dv.getTraloiC());
        btnd.setText(dv.getTraloiD());
        switch (i) {
            case 0:
                image.setImageResource(R.drawable.banhbo);
                break;
            case 1:
                image.setImageResource(R.drawable.banhyen);
                break;
            case 2:
                image.setImageResource(R.drawable.banhtam);
                break;
            case 3:
                image.setImageResource(R.drawable.banhkhot);
                break;
            case 4:
                image.setImageResource(R.drawable.banhbia);
                break;
            case 5:
                image.setImageResource(R.drawable.banhxeo);
                break;
            case 6:
                image.setImageResource(R.drawable.banhtet);
                break;
            case 7:
                image.setImageResource(R.drawable.cakhoto);
                break;
            case 8:
                image.setImageResource(R.drawable.duondua);
                break;
            case 9:
                image.setImageResource(R.drawable.bundaumamtom);
                break;
            case 10:
                image.setImageResource(R.drawable.banhcuon);
                break;
            case 11:
                image.setImageResource(R.drawable.chagio);
                break;
            case 12:
                image.setImageResource(R.drawable.banhchung);
                break;
            case 13:
                image.setImageResource(R.drawable.pho);
                break;
            case 14:
                image.setImageResource(R.drawable.hotvitlon);
                break;
            case 15:
                image.setImageResource(R.drawable.goicuon);
                break;
            case 16:
                image.setImageResource(R.drawable.balalot);
                break;
            case 17:
                image.setImageResource(R.drawable.banhcanh);
                break;

        }


        btndiem.setText("Điểm của bé: " + diem);
        answer = dv.getTraloi();
    }


}
