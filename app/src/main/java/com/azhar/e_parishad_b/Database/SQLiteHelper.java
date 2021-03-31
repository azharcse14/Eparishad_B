package com.azhar.e_parishad_b.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "final.db";
    public static final int VERSION_NUMBER = 1;

    Context context;
    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null,VERSION_NUMBER);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //Display All Data
    public Cursor displayAllData(String para){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String[] scripts = new String [] {para};
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM MNEntity b where b.kinnumber = ?",scripts,null);
//        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM MNEntity b where b.kinnumber = b.kinnumber", null);
        System.out.println(cursor);
//        cursor.close();
        return cursor;
    }

    public Cursor loanData(String para){
        System.out.println(para);
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String[] scripts = new String [] {para};
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM LoanEntity b where b.kinnumber = ?",scripts,null);
        return cursor;
    }

}
