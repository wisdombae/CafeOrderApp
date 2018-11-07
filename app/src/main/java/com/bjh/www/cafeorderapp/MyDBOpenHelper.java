package com.bjh.www.cafeorderapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBOpenHelper extends SQLiteOpenHelper {
    private static final String name = "order.db";
    private static final SQLiteDatabase.CursorFactory factory = null;
    private static final int version = 1;

    public MyDBOpenHelper(Context context) {
        super(context, name, factory, version);
    }

    public MyDBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                          int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE tableseat (tableseat_seq text PRIMARY KEY, tableseat_name TEXT);");
        db.execSQL("CREATE TABLE menu (menu_seq text PRIMARY KEY, menu_name TEXT, cost Integer);");
        db.execSQL("CREATE TABLE ordered_list (ordered_list_seq text PRIMARY KEY, " +
                "ordered_count integer, ordered_date text, tableseat_seq text, " +
                "tableseat_name text, menu_seq text, menu_name text, cost integer);");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE tableseat ;");
        db.execSQL("DROP TABLE menu ;");
        db.execSQL("DROP TABLE ordered_list ;");
        onCreate(db);
//        Toast.makeText(this.,"onUpgrade", Toast.LENGTH_LONG).show();
    }

    public void deleteRecord(SQLiteDatabase mdb, String cost) {
        mdb.execSQL("DELETE FROM menu WHERE cost ='" + cost + "';");
    }

}
