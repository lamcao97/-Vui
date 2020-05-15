package ptithcm.edu.vn.dovui;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

class SQLite extends SQLiteOpenHelper {

    SQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    void TruyVanKhongTraVe(String sql)
    {
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL(sql);
    }

    Cursor TruyVanTraVe(String sql)
    {
        SQLiteDatabase db=getWritableDatabase();
        return db.rawQuery(sql, null);
    }

}
