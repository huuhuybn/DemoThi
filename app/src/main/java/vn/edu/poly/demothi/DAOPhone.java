package vn.edu.poly.demothi;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import static vn.edu.poly.demothi.SqliteHelper.ID;
import static vn.edu.poly.demothi.SqliteHelper.NAME;
import static vn.edu.poly.demothi.SqliteHelper.PRICE;
import static vn.edu.poly.demothi.SqliteHelper.TABLE_NAME;

public class DAOPhone {

    private SqliteHelper sqliteHelper;

    public DAOPhone(SqliteHelper sqliteHelper) {
        this.sqliteHelper = sqliteHelper;
    }


    public long insertPhone(Phone phone) {
        SQLiteDatabase sqLiteDatabase = sqliteHelper.getReadableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(ID, phone.id);
        contentValues.put(NAME, phone.name);
        contentValues.put(PRICE, phone.price);

        long result = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

        return result;

    }

    public long updatePhone(Phone phone) {

        SQLiteDatabase sqLiteDatabase = sqliteHelper.getReadableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(ID, phone.id);
        contentValues.put(NAME, phone.name);
        contentValues.put(PRICE, phone.price);

        long result = sqLiteDatabase.update(TABLE_NAME, contentValues, ID + "=?",
                new String[]{phone.id});

        return result;
    }

    public long deletePhone(Phone phone) {
        SQLiteDatabase sqLiteDatabase = sqliteHelper.getReadableDatabase();

        long result = sqLiteDatabase.delete(TABLE_NAME, ID + "=?",
                new String[]{phone.id});

        return result;

    }

    public List<Phone> getAllPhones() {
        SQLiteDatabase sqLiteDatabase = sqliteHelper.getReadableDatabase();

        List<Phone> phones = new ArrayList<>();

        String SELECT_ALL = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(SELECT_ALL, null);

        if (cursor != null) {
            if (cursor.getCount() > 0) {

                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {

                    String id = cursor.getString(cursor.getColumnIndex(ID));

                    String name = cursor.getString(cursor.getColumnIndex(NAME));

                    String price = cursor.getString(cursor.getColumnIndex(PRICE));


                    Phone phone = new Phone();

                    phone.id = id;
                    phone.name = name;
                    phone.price = price;


                    phones.add(phone);

                    cursor.moveToNext();


                }

                cursor.close();

            }
        }

        return phones;

    }


}
