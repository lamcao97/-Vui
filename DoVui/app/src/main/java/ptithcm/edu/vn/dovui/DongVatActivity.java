package ptithcm.edu.vn.dovui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import ptithcm.edu.vn.dovui.Module.DongVatQuestion;
import ptithcm.edu.vn.dovui.Module.diem;

public class DongVatActivity extends AppCompatActivity implements View.OnClickListener {
    private int diem=0;
    Button btna,btnb,btnc,btnd,btnnext, btnsound, btndiem;
    ImageView image;
    DBManager data, datadiem;
    private String answer;
    ArrayList<DongVatQuestion> arrch = new ArrayList<>();
    ArrayList<diem> arrdiem = new ArrayList<>();
    int SLbe=0;
    Random random;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dongvat);



        datadiem = new DBManager(this, "diemso.db", null, 1);
        Cursor cursordiem = datadiem.TruyVanTraVe("Select * From Diem");
        while (cursordiem.moveToNext()){
            SLbe++;
        }

        data = new DBManager(this,"dongvat.db",null,1);
        data.TruyVanKhongTraVe("Create Table If not exists Animal(MaCH Integer Primary Key Autoincrement ,traloiA Varchar,traloiB Varchar,traloiC Varchar,traloiD Varchar,traloi Varchar,flag Integer)");

        Cursor cursor = data.TruyVanTraVe("Select * From Animal");
        while (cursor.moveToNext()){
            arrch.add(new DongVatQuestion(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getInt(6)));
        }
        int sum=0;
        for (DongVatQuestion element : arrch) {
            sum ++;
        }

        if(sum == 0){
            data.TruyVanKhongTraVe("Insert into Animal values (null, 'Con Heo','Con Gà','Con Chim','Con Vịt','Con Chim', 0)");
            data.TruyVanKhongTraVe("Insert into Animal values (null, 'Con Khỉ','Con Bò','Con Ngỗng','Con Mèo','Con Ngỗng', 0)");
            data.TruyVanKhongTraVe("Insert into Animal values (null, 'Con Voi','Con Vịt','Con Bò','Con Trâu','Con Bò', 0)");
            data.TruyVanKhongTraVe("Insert into Animal values (null, 'Con Mèo','Con Sư Tử','Con Cá','Con Hổ','Con Mèo', 0)");
            data.TruyVanKhongTraVe("Insert into Animal values (null, 'Con Chuột','Con Mèo','Con Gấu','Con Cáo','Con Chuột', 0)");
            data.TruyVanKhongTraVe("Insert into Animal values (null, 'Con Trâu','Con Chó','Con Chim','Con Heo','Con Heo', 0)");
            data.TruyVanKhongTraVe("Insert into Animal values (null, 'Con Bò','Con Giun','Con Chim','Con Lừa','Con Lừa', 0)");

            data.TruyVanKhongTraVe("Insert into Animal values (null, 'Con Heo','Con Gà','Con Hổ','Con Vịt','Con Hổ', 0)");
            data.TruyVanKhongTraVe("Insert into Animal values (null, 'Con Khỉ','Con Cáo','Con Ngỗng','Con Mèo','Con Cáo', 0)");
            data.TruyVanKhongTraVe("Insert into Animal values (null, 'Con Sư tử','Con Vịt','Con Bò','Con Trâu','Con Sư tử', 0)");
            data.TruyVanKhongTraVe("Insert into Animal values (null, 'Con Voi','Con Sư Tử','Con Cá','Con Hổ','Con Voi', 0)");
            data.TruyVanKhongTraVe("Insert into Animal values (null, 'Con Nai','Con Mèo','Con Gấu','Con Cáo','Con Nai', 0)");
            data.TruyVanKhongTraVe("Insert into Animal values (null, 'Con Trâu','Con Khỉ','Con Chim','Con Heo','Con Khỉ', 0)");
            data.TruyVanKhongTraVe("Insert into Animal values (null, 'Con Bò','Con Chó','Con Chim','Con Lừa','Con Chó', 0)");

            data.TruyVanKhongTraVe("Insert into Animal values (null, 'Con Chuột','Con Mèo','Con Gấu','Con Gà','Con Gà', 0)");
            data.TruyVanKhongTraVe("Insert into Animal values (null, 'Con Trâu','Con Chó','Con Chim','Con Vịt','Con Vịt', 0)");
            data.TruyVanKhongTraVe("Insert into Animal values (null, 'Con Bò','Con Giun','Con Cú','Con Lừa','Con Cú', 0)");
            while (cursor.moveToNext()){
                arrch.add(new DongVatQuestion(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getInt(6)));
            }
        }

        random = new Random();

//        btna = (Button)findViewById(R.id.btna);
//        btna.setText(dv.getTraloiB())
//        btnb = (Button)findViewById(R.id.btnb);
//        btnb.setText(dv.getTraloiB());
//        btnc = (Button)findViewById(R.id.btnc);
//        btnc.setText(dv.getTraloiC());
//        btnd = (Button)findViewById(R.id.btnd);
//        btnd.setText(dv.getTraloiD());



//        btna = findViewById(R.id.btna);
//        btna.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                xacnhan(b,1);
//            }
//        });
//        btnb = findViewById(R.id.btnb);
//        btnb.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                xacnhan(b,2);
//            }
//        });
//        btnc = findViewById(R.id.btnc);
//        btnc.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                xacnhan(b,3);
//            }
//        });
//        btnd = findViewById(R.id.btnd);
//        btnd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                xacnhan(b,4);
//            }
//        });

        btna = findViewById(R.id.btna);
        btna.setOnClickListener(this);

        btnb = findViewById(R.id.btnb);
        btnb.setOnClickListener(this);

        btnc = findViewById(R.id.btnc);
        btnc.setOnClickListener(this);

        btnd = findViewById(R.id.btnd);
        btnd.setOnClickListener(this);

        image = (ImageView) findViewById(R.id.tvv_imagequestion);
        image.setOnClickListener(this);

        int rd = random.nextInt(arrch.size());
        btnsound = (Button) findViewById(R.id.btnsound);

        btndiem = (Button) findViewById(R.id.btndiem);
        btndiem.setOnClickListener(this);

        sound(rd);
        NextQuestion(rd);
    }
//    private void xacnhan(){
//        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
//        alertDialog.setTitle("Thông báo");
//        alertDialog.setIcon(R.drawable.chamhoi);
//        alertDialog.setMessage("Đây là câu trả lời cuối cùng của bạn ?");
//
//        alertDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//            }
//        });
//        alertDialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//            }
//        });
//
//        alertDialog.show();
//
//    }

    @Override
    public void onClick(View v) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

        switch (v.getId()){
            case R.id.btna:

                alertDialog.setTitle("Thông báo");
                alertDialog.setIcon(R.drawable.chamhoi);
                alertDialog.setMessage("Đây là câu trả lời cuối cùng của bé ?");

                alertDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(btna.getText().equals(answer)){
                            diem = diem+100;
                            Toast.makeText(DongVatActivity.this, "Chính Xác", Toast.LENGTH_SHORT).show();
                            int rd = random.nextInt(arrch.size());
                            sound(rd);
                            NextQuestion(rd);
                        }else{
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

            case R.id.btnb:
                alertDialog.setTitle("Thông báo");
                alertDialog.setIcon(R.drawable.chamhoi);
                alertDialog.setMessage("Đây là câu trả lời cuối cùng của bé ?");

                alertDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if(btnb.getText().equals(answer)){
                            diem = diem+100;
                            Toast.makeText(DongVatActivity.this, "Chính Xác", Toast.LENGTH_SHORT).show();
                            int rd = random.nextInt(arrch.size());
                            sound(rd);
                            NextQuestion(rd);
                        }else{
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

            case R.id.btnc:
                alertDialog.setTitle("Thông báo");
                alertDialog.setIcon(R.drawable.chamhoi);
                alertDialog.setMessage("Đây là câu trả lời cuối cùng của bé ?");

                alertDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if(btnc.getText().equals(answer)){
                            diem = diem+100;
                            Toast.makeText(DongVatActivity.this, "Chính Xác", Toast.LENGTH_SHORT).show();
                            int rd = random.nextInt(arrch.size());
                            sound(rd);
                            NextQuestion(rd);
                        }else{
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

            case R.id.btnd:
                alertDialog.setTitle("Thông báo");
                alertDialog.setIcon(R.drawable.chamhoi);
                alertDialog.setMessage("Đây là câu trả lời cuối cùng của bé ?");

                alertDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if(btnd.getText().equals(answer)){
                            diem = diem+100;
                            Toast.makeText(DongVatActivity.this, "Chính Xác", Toast.LENGTH_SHORT).show();
                            int rd = random.nextInt(arrch.size());
                            sound(rd);
                            NextQuestion(rd);
                        }else{
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
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(DongVatActivity.this);
        alertDialogBuilder
                .setMessage("Bé đã trả lời sai rồi\n Số điểm của bé: "+diem)
                .setCancelable(false)
                .setPositiveButton("Chơi Lại", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(getApplicationContext(), DongVatActivity.class));
                    }
                })
                .setNegativeButton("Thoát", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.exit(0);
                    }
                });
        alertDialogBuilder.show();
        datadiem.TruyVanKhongTraVe("UPDATE Diem set DiemDongVat='"+diem+"' WHERE MaDiem='"+SLbe+"'");
    }

    private void NextQuestion(int i){
        DongVatQuestion dv = arrch.get(i);
        btna.setText(dv.getTraloiA());
        btnb.setText(dv.getTraloiB());
        btnc.setText(dv.getTraloiC());
        btnd.setText(dv.getTraloiD());
        if (i == 0){ image.setImageResource(R.drawable.dongvat0); }
        else if (i==1){
            image.setImageResource(R.drawable.dongvat1);
        }
        else if (i==2){
            image.setImageResource(R.drawable.dongvat2);
        }
        else if (i==3){
            image.setImageResource(R.drawable.dongvat3);
        }
        else if (i==4){
            image.setImageResource(R.drawable.dongvat4);
        }
        else if (i==5){
            image.setImageResource(R.drawable.dongvat5);
        }
        else if (i==6){
            image.setImageResource(R.drawable.dongvat6);
        }
        else if (i==7){
            image.setImageResource(R.drawable.dongvat7);
        }
        else if (i==8){
            image.setImageResource(R.drawable.dongvat8);
        }
        else if (i==9){
            image.setImageResource(R.drawable.dongvat9);
        }
        else if (i==10){
            image.setImageResource(R.drawable.dongvat10);
        }
        else if (i==11){
            image.setImageResource(R.drawable.dongvat11);
        }
        else if (i==12){
            image.setImageResource(R.drawable.dongvat12);
        }
        else if (i==13){
            image.setImageResource(R.drawable.dongvat13);
        }
        else if (i==14){
            image.setImageResource(R.drawable.dongvat14);
        }
        else if (i==15){
            image.setImageResource(R.drawable.dongvat15);
        }
        else if (i==16){
            image.setImageResource(R.drawable.dongvat16);
        }
        btndiem.setText("Điểm của bé: "+diem);

        answer = dv.getTraloi();
    }

    private void sound(int i){

        if (i == 0){
            btnsound.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MediaPlayer mediaPlayer = MediaPlayer.create(DongVatActivity.this, R.raw.chim);
                    mediaPlayer.start();
                }
            });
        }
        else if (i==1){
            btnsound.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MediaPlayer mediaPlayer = MediaPlayer.create(DongVatActivity.this, R.raw.ngong);
                    mediaPlayer.start();
                }
            });
        }
        else if (i==2){
            btnsound.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MediaPlayer mediaPlayer = MediaPlayer.create(DongVatActivity.this, R.raw.bo);
                    mediaPlayer.start();

                }
            });
        }
        else if (i==3){
            btnsound.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MediaPlayer mediaPlayer = MediaPlayer.create(DongVatActivity.this, R.raw.meo);
                    mediaPlayer.start();

                }
            });
        }
        else if (i==4){
            btnsound.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MediaPlayer mediaPlayer = MediaPlayer.create(DongVatActivity.this, R.raw.chuot);
                    mediaPlayer.start();

                }
            });
        }
        else if (i==5){
            btnsound.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MediaPlayer mediaPlayer = MediaPlayer.create(DongVatActivity.this, R.raw.heo);
                    mediaPlayer.start();

                }
            });
        }
        else if (i==6){
            btnsound.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MediaPlayer mediaPlayer = MediaPlayer.create(DongVatActivity.this, R.raw.lua);
                    mediaPlayer.start();

                }
            });
        }
        else if (i==7){
            btnsound.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MediaPlayer mediaPlayer = MediaPlayer.create(DongVatActivity.this, R.raw.ho);
                    mediaPlayer.start();

                }
            });
        }
        else if (i==8){
            btnsound.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MediaPlayer mediaPlayer = MediaPlayer.create(DongVatActivity.this, R.raw.cao);
                    mediaPlayer.start();

                }
            });
        }
        else if (i==9){
            btnsound.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MediaPlayer mediaPlayer = MediaPlayer.create(DongVatActivity.this, R.raw.sutu);
                    mediaPlayer.start();

                }
            });
        }
        else if (i==10){
            btnsound.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MediaPlayer mediaPlayer = MediaPlayer.create(DongVatActivity.this, R.raw.voi);
                    mediaPlayer.start();

                }
            });
        }
        else if (i==11){
            btnsound.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MediaPlayer mediaPlayer = MediaPlayer.create(DongVatActivity.this, R.raw.nai);
                    mediaPlayer.start();

                }
            });
        }
        else if (i==12){
            btnsound.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MediaPlayer mediaPlayer = MediaPlayer.create(DongVatActivity.this, R.raw.khi);
                    mediaPlayer.start();

                }
            });
        }
        else if (i==13){
            btnsound.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MediaPlayer mediaPlayer = MediaPlayer.create(DongVatActivity.this, R.raw.cho);
                    mediaPlayer.start();

                }
            });
        }
        else if (i==14){
            btnsound.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MediaPlayer mediaPlayer = MediaPlayer.create(DongVatActivity.this, R.raw.ga);
                    mediaPlayer.start();

                }
            });
        }
        else if (i==15){
            btnsound.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MediaPlayer mediaPlayer = MediaPlayer.create(DongVatActivity.this, R.raw.vit);
                    mediaPlayer.start();

                }
            });
        }
        else if (i==16){
            btnsound.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MediaPlayer mediaPlayer = MediaPlayer.create(DongVatActivity.this, R.raw.chimcu);
                    mediaPlayer.start();

                }
            });
        }

    }


}
