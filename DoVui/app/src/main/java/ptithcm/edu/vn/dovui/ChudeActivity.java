package ptithcm.edu.vn.dovui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import ptithcm.edu.vn.dovui.Module.XemDiem;
import ptithcm.edu.vn.dovui.Module.diem;

public class ChudeActivity extends AppCompatActivity {
    SQLite data ;
    TextView txtbechonchude;
    Button btntoan;
    LinearLayout laydongvat, layamnhac, layxemdiem, layiq;
    Button btndongvat, btnamnhac, btnxemdiem, btniq, btnMonAn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chude);




        Intent intent = new Intent(getIntent());
        String tenbe = intent.getStringExtra("tenbe");


        txtbechonchude = findViewById(R.id.txtbechonchude);
        txtbechonchude.setText("BÉ "+tenbe+" CHỌN CHỦ ĐỀ");
        btntoan = findViewById(R.id.btntoan);
        btntoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = new SQLite(ChudeActivity.this, "toanhoc.sqlite", null, 1);
                data.TruyVanKhongTraVe("Create Table If not exists Cauhoitoanhoc(id Integer Primary Key Autoincrement , cauhoi Varchar)");
                /* data.TruyVanKhongTraVe("Insert into Cauhoitoanhoc values (null,'cho Khoa là ai?' )");
                data.TruyVanKhongTraVe("Insert into Cauhoitoanhoc values (null,'Cuong là ai?' )");
                data.TruyVanKhongTraVe("Insert into Cauhoitoanhoc values (null,'Triet là ai?' )");*/
                Intent intent = new Intent(ChudeActivity.this,ToanActivity.class);
                startActivity(intent);
            }
        });

        laydongvat = findViewById(R.id.laydongvat);
        laydongvat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChudeActivity.this,DongVatActivity.class);
                startActivity(intent);
            }
        });
        btnMonAn = findViewById(R.id.btnMonAn);
        btnMonAn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChudeActivity.this,MonAnActivity.class);
                startActivity(intent);
            }
        });
        btndongvat = findViewById(R.id.btndongvat);
        btndongvat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChudeActivity.this,DongVatActivity.class);
                startActivity(intent);
            }
        });

        layamnhac = findViewById(R.id.layamnhac);
        layamnhac.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChudeActivity.this,AmNhacActivity.class);
                startActivity(intent);
            }
        });
        btnamnhac = findViewById(R.id.btnamnhac);
        btnamnhac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChudeActivity.this,AmNhacActivity.class);
                startActivity(intent);
            }
        });

        layxemdiem = findViewById(R.id.layxemdiem);
        layxemdiem.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChudeActivity.this, XemDiem.class);
                startActivity(intent);
            }
        });
        btnxemdiem = findViewById(R.id.btnxemdiem);
        btnxemdiem.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChudeActivity.this, XemDiem.class);
                startActivity(intent);
            }
        });

        layiq = findViewById(R.id.layiq);
        layiq.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChudeActivity.this,IQActivity.class);
                startActivity(intent);
            }
        });
        btniq = findViewById(R.id.btniq);
        btniq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChudeActivity.this,IQActivity.class);
                startActivity(intent);
            }
        });


}}
