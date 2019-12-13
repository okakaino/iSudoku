package me.tgao.isudoku;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "records.db";
    private static final String TABLE_NAME = "record";
    public static final String DURATION = "duration";
    public static final String DATE = "date";
    
    public DatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DURATION + " INTEGER NOT NULL, " +
                DATE + " INTEGER NOT NULL DEFAULT CURRENT_TIMESTAMP)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(Record record) {
        ContentValues contentValues = getContentValues(record);

        SQLiteDatabase db = this.getWritableDatabase();

        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        }

        return true;
    }

    public Cursor getListContents() {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor data = db.query(TABLE_NAME, null, null, null, null, null, "duration ASC");

        return data;
    }

    private ContentValues getContentValues(Record record) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DURATION, record.getTime());
        contentValues.put(DATE, record.getDate());

        return contentValues;
    }
}
