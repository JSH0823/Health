package com.example.first;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBManager extends SQLiteOpenHelper {
    public DBManager(Context context){
        super(context,"person", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS person (name text, height text," +
                " weight text, target text);");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {


    }
}
