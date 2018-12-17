package vn.edu.poly.demothi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SqliteHelper extends SQLiteOpenHelper {

    // tao bang
    public final static String TABLE_NAME = "Phone";

    public final static String ID = "id";
    public final static String NAME = "name";
    public final static String PRICE = "price";


    // CREATE TABLE Phone (id TEXT PRIMARY KEY, name TEXT, price TEXT)

    public final static String CREATE_TABLE_PHONE = "CREATE TABLE " + TABLE_NAME + " (" +
            "" + ID + "  TEXT PRIMARY KEY," +
            "" + NAME + "  TEXT," +
            "" + PRICE + "  TEXT " +
            ")";


    //
    public SqliteHelper(Context context) {
        super(context, "abc.sql", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(CREATE_TABLE_PHONE);
        Log.e("TABLE_PHONE",CREATE_TABLE_PHONE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
