package com.azhar.e_parishad_b.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class SQLiteHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "final.db";
    public static final int VERSION_NUMBER = 1;
    public static final String TABLE_NAME = "MNEntity";


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


    public ArrayList<String> memberName(String kinnumber){
        System.out.println(kinnumber);
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String[] scripts = new String [] {kinnumber};
        ArrayList<String> name = new ArrayList<String>();

        try {
            Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM MNEntity a where a.kinnumber = ?",scripts,null);
//            System.out.println("Cursor: "+cursor);
//            System.out.println("Count: "+cursor.getCount());


            if (cursor.getCount()>0){
                Cursor cursorone = sqLiteDatabase.rawQuery("SELECT * FROM MNEntity a where a.kinnumber = ?",scripts,null);
                while(cursorone.moveToNext()){
                    String newname = cursorone.getString(1);
                    String fnewname = cursorone.getString(4);
                    name.add(newname);
                    name.add(fnewname);
                    System.out.println("cursorone:  "+cursorone.getString(1));
                }
            }

            System.out.println("ArrayList: "+name);
//            return name;

        }catch (Exception e){
            System.out.println("e"+e);
        }

        return name;
    }


    //=========================================================================================
    public ArrayList<String> mothersName(String kinnumber){
        System.out.println(kinnumber);
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String[] scripts = new String [] {kinnumber};
        ArrayList<String> mName = new ArrayList<String>();

        try {
            Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM MNEntity a where a.kinnumber = ?",scripts,null);

            if (cursor.getCount()>0){
                Cursor cursorone = sqLiteDatabase.rawQuery("SELECT * FROM MNEntity a where a.kinnumber = ?",scripts,null);
                while(cursorone.moveToNext()){
                    String newname = cursorone.getString(5);
                    mName.add(newname);
                }
            }

        }catch (Exception e){
            System.out.println("e"+e);
        }

        return mName;
    }

}
