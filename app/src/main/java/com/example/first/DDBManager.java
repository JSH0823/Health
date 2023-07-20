package com.example.first;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DDBManager extends SQLiteOpenHelper {
    public DDBManager(Context context){ super(context,"cal",null,1);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS cal(c_day text, breakfast text, " +
                "lunch text, dinner text, day_weight text, promise int);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
