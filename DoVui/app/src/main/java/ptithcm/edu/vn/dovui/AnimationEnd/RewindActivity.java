package ptithcm.edu.vn.dovui.AnimationEnd;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import ptithcm.edu.vn.dovui.ChudeActivity;
import ptithcm.edu.vn.dovui.DBManager;
import ptithcm.edu.vn.dovui.MonAnActivity;
import ptithcm.edu.vn.dovui.R;

public class RewindActivity extends AppCompatActivity {
    LinearLayout l1, l2;
    Button btnBack;
    TextView tvDiem;
    DBManager data, datadiem;
    int SLbe = 0;

    int diem = 0;
    Animation uptodown, downtoup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewind);
        tvDiem = findViewById(R.id.tvtDiem);
        Intent intent = getIntent();
        diem = intent.getIntExtra("diem", diem);
        datadiem = new DBManager(this, "diemso.db", null, 1);
        Cursor cursordiem = datadiem.TruyVanTraVe("Select * From Diem");
        while (cursordiem.moveToNext()) {
            SLbe++;
        }
        tvDiem.setText(String.valueOf(diem));
        datadiem.TruyVanKhongTraVe("UPDATE Diem set DiemMonAn='" + diem + "' WHERE MaDiem='" + SLbe + "'");

        btnBack = (Button) findViewById(R.id.buttonsub);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RewindActivity.this, ChudeActivity.class);
                startActivity(intent);
            }
        });
        l1 = (LinearLayout) findViewById(R.id.l1);
        l2 = (LinearLayout) findViewById(R.id.l2);
        uptodown = AnimationUtils.loadAnimation(this, R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this, R.anim.downtoup);
        l1.setAnimation(uptodown);
        l2.setAnimation(downtoup);
    }
}
