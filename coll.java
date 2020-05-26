package com.sharmaji.rattingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class coll extends SQLiteOpenHelper {

    public coll(@Nullable Context context) {

        super(context,"my.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table vipulji(datee text ,timee text primary key,id text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists vipulji");

    }
    public boolean insert(String aa,String yy,String x){
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("datee",aa);
        contentValues.put("timee",yy);
        contentValues.put("id",x);
        long a = sqLiteDatabase.insert("vipulji", null, contentValues);
        if (a == -1) {
            return false;
        } else return true;

    }
    public ArrayList<String> getvalue1() {
        ArrayList<String> namelist = new ArrayList<>();
        SQLiteDatabase database=this.getReadableDatabase();
        String query="select * from vipulji";
        Cursor cursor= (Cursor) database.rawQuery(query,null);
        if(cursor!=null) {
            if (cursor.moveToFirst()) {
                while (!cursor.isAfterLast()) {
                    String name = cursor.getString(cursor.getColumnIndex("datee"));
                    namelist.add(name);
                    cursor.moveToNext();

                }
            }
        }
        return namelist;

    }
    public ArrayList<String> getvalue2() {
        ArrayList<String> namelist = new ArrayList<>();
        SQLiteDatabase database=this.getReadableDatabase();
        String query="select * from vipulji";
        Cursor cursor= (Cursor) database.rawQuery(query,null);
        if(cursor!=null) {
            if (cursor.moveToFirst()) {
                while (!cursor.isAfterLast()) {
                    String name = cursor.getString(cursor.getColumnIndex("timee"));
                    namelist.add(name);
                    cursor.moveToNext();

                }
            }
        }
        return namelist;

    }
    public ArrayList<String> getvalue3() {
        ArrayList<String> namelist = new ArrayList<>();
        SQLiteDatabase database=this.getReadableDatabase();
        String query="select * from vipulji";
        Cursor cursor= (Cursor) database.rawQuery(query,null);
        if(cursor!=null) {
            if (cursor.moveToFirst()) {
                while (!cursor.isAfterLast()) {
                    String name = cursor.getString(cursor.getColumnIndex("id"));
                    namelist.add(name);
                    cursor.moveToNext();

                }
            }
        }
        return namelist;

    }


}
