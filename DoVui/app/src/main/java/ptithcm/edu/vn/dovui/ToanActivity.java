package ptithcm.edu.vn.dovui;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import ptithcm.edu.vn.dovui.Module.diem;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Random;


public class ToanActivity extends AppCompatActivity {
    private Integer diem = 0;
    final Random rd = new Random();
    TextView cauhoitoan, diemhientai;
    SQLite data, datadiem;
    Cursor cursor;
    RadioButton dapanA, dapanB, dapanC, dapanD;
    Integer a = rd.nextInt(9);
    ArrayList<diem> arrdiem = new ArrayList<>();
    int SLbe = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toan);
        Intent intent = getIntent();
        diem = intent.getIntExtra("diem",0);

        datadiem = new SQLite(ToanActivity.this, "diemso.db", null, 1);
        Cursor cursordiem = datadiem.TruyVanTraVe("Select * From Diem");
        while(cursordiem.moveToNext()){
            SLbe++;
        }

        data = new SQLite(ToanActivity.this, "toanhoc.sqlite", null, 1);
        data.TruyVanKhongTraVe("Create Table If not exists dapannguoidung(id Integer , dapannguoidung Varchar)");
        cauhoitoan = findViewById(R.id.txtcauhoitoan);
        diemhientai = findViewById(R.id.txtdiemhientai);
        dapanA = findViewById(R.id.dapana);
        dapanB = findViewById(R.id.dapanb);
        dapanC = findViewById(R.id.dapanc);
        dapanD = findViewById(R.id.dapand);
        final Integer c = a;
        cursor = data.TruyVanTraVe("Select cauhoi From Cauhoitoanhoc ");
        cursor.moveToPosition(a);
        cauhoitoan.setText(cursor.getString(0));
        cursor = data.TruyVanTraVe("Select dapana From Cauhoitoanhoc");
        cursor.moveToPosition(a);
        dapanA.setText("A." + cursor.getString(0));
        cursor = data.TruyVanTraVe("Select dapanb From Cauhoitoanhoc");
        cursor.moveToPosition(a);
        dapanB.setText("B." + cursor.getString(0));
        cursor = data.TruyVanTraVe("Select dapanc From Cauhoitoanhoc");
        cursor.moveToPosition(a);
        dapanC.setText("C." + cursor.getString(0));
        cursor = data.TruyVanTraVe("Select dapand From Cauhoitoanhoc");
        cursor.moveToPosition(a);
        dapanD.setText("D." + cursor.getString(0));
        cursor = data.TruyVanTraVe("Select dapan From Cauhoitoanhoc");
        cursor.moveToPosition(a);
        final String abc = cursor.getString(0);
        diemhientai.setText("Điểm của bé là:"+diem);

        dapanA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(ToanActivity.this);
                builder.setTitle("Thông báo");
                builder.setMessage("Bé có chắc chắn chọn đáp án này chứ?");
                builder.setCancelable(false);
                builder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (dapanA.isChecked() == true && abc.equalsIgnoreCase("1") == true) {
                            dapanA.setBackgroundColor(Color.GREEN);

                              Intent intent = new Intent(ToanActivity.this, ToanActivity.class);
//                            startActivity(intent);
                            diem = diem+100;
                            intent.putExtra("diem",diem);
                            startActivity(intent);
                            Toast.makeText(ToanActivity.this, "chính xác", Toast.LENGTH_SHORT).show();
                        } else {
                            showAlertDialog();
                        }

                    }
                });
                builder.setNegativeButton("Chọn lại", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ToanActivity.this, "Bé vui lòng chọn lại!!!", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();


            }
        });
        diemhientai.setText("Điểm của bé là:"+diem);
        dapanB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ToanActivity.this);
                builder.setTitle("Thông báo");
                builder.setMessage("Bé có chắc chắn chọn đáp án này chứ?");
                builder.setCancelable(false);
                builder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (dapanB.isChecked() == true && abc.equalsIgnoreCase("2") == true) {
                            dapanB.setBackgroundColor(Color.GREEN);

                            Intent intent = new Intent(ToanActivity.this, ToanActivity.class);
//                            startActivity(intent);
                            diem = diem+100;
                            intent.putExtra("diem",diem);
                            startActivity(intent);
                            Toast.makeText(ToanActivity.this, "chính xác", Toast.LENGTH_SHORT).show();
                        } else {
                            showAlertDialog();
                        }
                    }
                });
                builder.setNegativeButton("Chọn lại", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ToanActivity.this, "Bé vui lòng chọn lại!!!", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });
        diemhientai.setText("Điểm của bé là:"+diem);
        dapanC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ToanActivity.this);
                builder.setTitle("Thông báo");
                builder.setMessage("Bé có chắc chắn chọn đáp án này chứ?");
                builder.setCancelable(false);
                builder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (dapanC.isChecked() == true && abc.equalsIgnoreCase("3") == true) {
                            dapanC.setBackgroundColor(Color.GREEN);

                            Intent intent = new Intent(ToanActivity.this, ToanActivity.class);
//                            startActivity(intent);
                            diem = diem+100;
                            intent.putExtra("diem",diem);
                            startActivity(intent);
                            Toast.makeText(ToanActivity.this, "chính xác", Toast.LENGTH_SHORT).show();
                        } else {
                            showAlertDialog();
                        }
                    }
                });
                builder.setNegativeButton("Chọn lại", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ToanActivity.this, "Bé vui lòng chọn lại!!!", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });
        diemhientai.setText("Điểm của bé là:"+diem);
        dapanD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ToanActivity.this);
                builder.setTitle("Thông báo");
                builder.setMessage("Bé có chắc chắn chọn đáp án này chứ?");
                builder.setCancelable(false);
                builder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (dapanD.isChecked() == true && abc.equalsIgnoreCase("4") == true) {
                            dapanD.setBackgroundColor(Color.GREEN);

                            Intent intent = new Intent(ToanActivity.this, ToanActivity.class);
//                            startActivity(intent);
                            diem = diem+100;
                            intent.putExtra("diem",diem);
                            startActivity(intent);
                            Toast.makeText(ToanActivity.this, "chính xác", Toast.LENGTH_SHORT).show();
                        } else {
                            showAlertDialog();
                        }
                    }
                });
                builder.setNegativeButton("Chọn lại", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ToanActivity.this, "Bé vui lòng chọn lại!!!", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });

        diemhientai.setText("Điểm của bé là:"+diem);
    }

    public void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông báo");
        builder.setMessage("Đáp án sai rồi!! bé muốn thế nào?");
        builder.setCancelable(false);
        builder.setPositiveButton("Chơi lại", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(ToanActivity.this, ToanActivity.class);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("Chọn chủ đề khác", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(ToanActivity.this, ChudeActivity.class);
                startActivity(intent);
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        Intent intent = new Intent(ToanActivity.this, ToanActivity.class);
        intent.putExtra("diem",diem);
        datadiem.TruyVanKhongTraVe("UPDATE Diem set DiemToan='"+diem+"' WHERE MaDiem='"+SLbe+"'");
    }



}
