package ptithcm.edu.vn.dovui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class kqtoanActivity extends AppCompatActivity {
  ListView lvkqtoan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ketqua_toanhoc);
        lvkqtoan = findViewById(R.id.lvkqtoan);

    }
}
