package ptithcm.edu.vn.dovui.Module;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import ptithcm.edu.vn.dovui.Adapter.DiemAdapter;
import ptithcm.edu.vn.dovui.DBManager;
import ptithcm.edu.vn.dovui.R;

public class XemDiem extends AppCompatActivity {

    private ListView lvResult;
    DBManager datadiem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xemdiem);

        lvResult = (ListView) findViewById(R.id.lv_result);

        ArrayList<diem> arrdiem = new ArrayList<>();


        datadiem = new DBManager(this, "diemso.db", null, 1);
        Cursor cursordiem = datadiem.TruyVanTraVe("Select * From Diem");
        while (cursordiem.moveToNext()){
            arrdiem.add(new diem(cursordiem.getInt(0),cursordiem.getString(1),cursordiem.getInt(2),cursordiem.getInt(3),cursordiem.getInt(4),cursordiem.getInt(5),cursordiem.getInt(6)));
        }

        DiemAdapter diemAdapter = new DiemAdapter(this, R.layout.row_xemdiem, arrdiem);
        diemAdapter.setNotifyOnChange(true);
        lvResult.setAdapter(diemAdapter);
    }
}
