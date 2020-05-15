package ptithcm.edu.vn.dovui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnchoingay,btnthoat;
    EditText edttenbe;
    DBManager datadiem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnchoingay = findViewById(R.id.btnchoingay);
        btnthoat = findViewById(R.id.btnthoat);
        edttenbe = findViewById(R.id.edttenbe);

        datadiem = new DBManager(this,"diemso.db",null, 1);
        btnchoingay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (edttenbe.getText().toString().trim().equals("")==true){
                    Toast.makeText(MainActivity.this,  "Bé chưa nhập tên!!!",Toast.LENGTH_SHORT).show();
                }else{
                Intent intent = new Intent(MainActivity.this,ChudeActivity.class);
                intent.putExtra("tenbe",edttenbe.getText().toString().toUpperCase());
                    String tenbe = edttenbe.getText().toString().toUpperCase();
                    datadiem.TruyVanKhongTraVe("Create Table If not exists Diem(MaDiem Integer Primary Key Autoincrement, Ten Varchar, DiemToan Integer, DiemDongVat Integer, DiemAmNhac Integer, DiemIQ Integer, DiemMonAn Integer)");
                    datadiem.TruyVanKhongTraVe("Insert into Diem values (null,'"+tenbe+"',0,0,0,0,0)");
                startActivity(intent);}
            }
        });
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
