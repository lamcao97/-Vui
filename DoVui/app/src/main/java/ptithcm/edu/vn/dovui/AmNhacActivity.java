package ptithcm.edu.vn.dovui;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import ptithcm.edu.vn.dovui.Module.AmNhacQuestion;
import ptithcm.edu.vn.dovui.Module.diem;

public class AmNhacActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1, btn2, btn3, btn4, btndiem;
    TextView txcauhoi;
    private String answer;
    ArrayList<AmNhacQuestion> arrcauhoi = new ArrayList<>();
    Random random;
    DBManager data,datadiem;
    ArrayList<diem> arrdiem = new ArrayList<>();
    int SLbe=0;
    private int diem=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amnhac);

        //đổi màu theo thời gian
        btndiem = (Button) findViewById(R.id.btndiem);
        int RED = 0xffFF0000;
        int BLUE = 0xff0000FF;
        ValueAnimator colorAnim = ObjectAnimator.ofInt(btndiem, "textColor", RED, BLUE);
        colorAnim.setDuration(500);
        colorAnim.setEvaluator(new ArgbEvaluator());
        colorAnim.setRepeatCount(ValueAnimator.INFINITE);
        colorAnim.setRepeatMode(ValueAnimator.REVERSE);
        colorAnim.start();

        datadiem = new DBManager(this, "diemso.db", null, 1);
        Cursor cursordiem = datadiem.TruyVanTraVe("Select * From Diem");
        while (cursordiem.moveToNext()){
            SLbe++;
        }

        data = new DBManager(this, "amnhac.db", null, 1);
        data.TruyVanKhongTraVe("Create Table If not exists AmNhac(MaCH Integer Primary Key Autoincrement ,cauhoi Varchar, traloi1 Varchar,traloi2 Varchar,traloi3 Varchar,traloi4 Varchar,traloidung Varchar,flag Integer)");

        Cursor cursor = data.TruyVanTraVe("Select * From AmNhac");
        while (cursor.moveToNext()) {
            arrcauhoi.add(new AmNhacQuestion(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getInt(7)));
        }
        int sum = 0;
        for (AmNhacQuestion element : arrcauhoi) {
            sum++;
        }
        if (sum == 0) {
            data.TruyVanKhongTraVe("Insert into AmNhac values (null, 'Hãy điền từ còn thiếu  vào đoạn sau: Con...be bé, nó đậu cành tre','Cò','Heo','Chuột','Trâu','Cò', 0)");
            data.TruyVanKhongTraVe("Insert into AmNhac values (null, 'Hãy điền từ còn thiếu  vào đoạn sau: Bắc kim thang, cà lang,...rợ','Cà','Dưa leo','Bí','Hành','Bí', 0)");
            data.TruyVanKhongTraVe("Insert into AmNhac values (null, 'Hãy điền từ còn thiếu  vào đoạn sau: Cháu lên...., cháu vô mẫu giáo','Năm','Ba','Mười','Tám','Ba', 0)");
            data.TruyVanKhongTraVe("Insert into AmNhac values (null, 'Hãy điền từ còn thiếu  vào đoạn sau: Ba thương con, vì con giống....','Cháu','Ông','Dì','Mẹ','Mẹ', 0)");
            data.TruyVanKhongTraVe("Insert into AmNhac values (null, 'Hãy điền từ còn thiếu  vào đoạn sau: Nhà em có con..., chú mèo kêu meo meo','Cò','Heo','Chuột','Mèo','Mèo', 0)");
            data.TruyVanKhongTraVe("Insert into AmNhac values (null, 'Hãy điền từ còn thiếu  vào đoạn sau: Cô dạy em bài thể dục buổi sáng. Một, hai, ba,...hít thở, hít thở.','Bốn','Năm','Sáu','Tám','Bốn', 0)");
            data.TruyVanKhongTraVe("Insert into AmNhac values (null, 'Hãy điền từ còn thiếu  vào đoạn sau: Mồng tám tháng ba, em ra thăm...., chọn một bông hoa.','Nhà','Sân','Vườn','Ngõ','Vườn', 0)");
            data.TruyVanKhongTraVe("Insert into AmNhac values (null, 'Hãy điền từ còn thiếu  vào đoạn sau: Hai vây xinh xinh, cá...bơi trong bể nước.','Xanh','Vàng','Trắng','Nâu','Vàng', 0)");
            data.TruyVanKhongTraVe("Insert into AmNhac values (null, 'Hãy điền từ còn thiếu  vào đoạn sau: Chị ong...nâu, chị bay đi đâu đi đâu.','Nâu','Xanh','Xám','Đỏ','Nâu', 0)");
            data.TruyVanKhongTraVe("Insert into Animal values (null, 'Hãy điền từ còn thiếu  vào đoạn sau: ....là ngày đầu tuần, bé hứa cố gắng chăm ngoan.','Thứ Tư','Thứ Năm','Thứ Bảy','Thứ Hai','Thứ Hai', 0)");
            while (cursor.moveToNext()) {
                arrcauhoi.add(new AmNhacQuestion(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getInt(7)));
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

        txcauhoi = findViewById(R.id.txcauhoi);
        txcauhoi.setOnClickListener(this);

        btndiem = (Button) findViewById(R.id.btndiem);
        btndiem.setOnClickListener(this);

        int rd = random.nextInt(arrcauhoi.size());
        NextQuestion(rd);
    }

    @Override
    public void onClick(View v) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

        switch (v.getId()){
            case R.id.btn1:

                alertDialog.setTitle("Thông báo");
                alertDialog.setIcon(R.drawable.chamhoi);
                alertDialog.setMessage("Bé đã chắc chắn đáp án này chưa ?");

                alertDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(btn1.getText().equals(answer)){
                            diem = diem+100;
                            Toast.makeText(AmNhacActivity.this, "Bé Trả Lời Đúng Rồi Nè!", Toast.LENGTH_SHORT).show();
                            int rd = random.nextInt(arrcauhoi.size());
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

            case R.id.btn2:
                alertDialog.setTitle("Thông báo");
                alertDialog.setIcon(R.drawable.chamhoi);
                alertDialog.setMessage("Bé đã chắc chắn đáp án này chưa ?");

                alertDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if(btn2.getText().equals(answer)){
                            diem = diem+100;
                            Toast.makeText(AmNhacActivity.this, "Bé Trả Lời Đúng Rồi Nè!", Toast.LENGTH_SHORT).show();
                            int rd = random.nextInt(arrcauhoi.size());
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

            case R.id.btn3:
                alertDialog.setTitle("Thông báo");
                alertDialog.setIcon(R.drawable.chamhoi);
                alertDialog.setMessage("Bé đã chắc chắn đáp án này chưa ?");

                alertDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if(btn3.getText().equals(answer)){
                            diem = diem+100;
                            Toast.makeText(AmNhacActivity.this, "Bé Trả Lời Đúng Rồi Nè!", Toast.LENGTH_SHORT).show();
                            int rd = random.nextInt(arrcauhoi.size());
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

            case R.id.btn4:
                alertDialog.setTitle("Thông báo");
                alertDialog.setIcon(R.drawable.chamhoi);
                alertDialog.setMessage("Bé đã chắc chắn đáp án này chưa ?");

                alertDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if(btn4.getText().equals(answer)){
                            diem = diem+100;
                            Toast.makeText(AmNhacActivity.this, "Bé Trả Lời Đúng Rồi Nè!", Toast.LENGTH_SHORT).show();
                            int rd = random.nextInt(arrcauhoi.size());
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
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(AmNhacActivity.this);
        alertDialogBuilder
                .setMessage("Bé đã trả lời sai rồi nè!\n Số điểm của bé: "+diem)
                .setCancelable(false)
                .setPositiveButton("Bé có muốn chơi lại không?", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(getApplicationContext(), AmNhacActivity.class));
                    }
                })
                .setNegativeButton("Thoát", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.exit(0);
                    }
                });
        alertDialogBuilder.show();
        datadiem.TruyVanKhongTraVe("UPDATE Diem set DiemAmNhac='"+diem+"' WHERE MaDiem='"+SLbe+"'");

    }

    private void NextQuestion(int i){
        AmNhacQuestion am = arrcauhoi.get(i);
        txcauhoi.setText(am.getCauhoi());
        btn1.setText(am.getTraloi1());
        btn2.setText(am.getTraloi2());
        btn3.setText(am.getTraloi3());
        btn4.setText(am.getTraloi4());


        btndiem.setText("Điểm của bé: "+diem);

        answer = am.getTraloidung();

    }

}
