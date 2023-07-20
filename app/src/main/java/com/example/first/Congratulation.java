package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

//import com.bumptech.glide.Glide;

public class Congratulation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congratulation);
        Intent con = getIntent();
        setTitle("Congratultions!!");

        ImageView congratulation = (ImageView) findViewById(R.id.cong);
        Glide.with(this).load(R.raw.wow).into(congratulation);

        ImageView congratulation2 = (ImageView) findViewById(R.id.cong2);
        Glide.with(this).load(R.raw.wow).into(congratulation2);
    }

    public void goReSet(View v){
        Intent intent = new Intent(getApplicationContext(),reSet.class);
        startActivity(intent);
    }
    public void finishProgram(View v){
        DBManager dbm1 = new DBManager(this);
        DDBManager dbm2 = new DDBManager(this);
        SQLiteDatabase sqlDB1, sqlDB2;
        sqlDB1 = dbm1.getWritableDatabase();
        sqlDB2 = dbm2.getWritableDatabase();

        sqlDB1.execSQL("DELETE FROM person");
        sqlDB2.execSQL("DELETE FROM cal");

        sqlDB1.close();
        sqlDB2.close();
        dbm1.close();
        dbm2.close();

        //finish();
        PackageManager packageManager = getPackageManager();
        Intent intent = packageManager.getLaunchIntentForPackage(getPackageName());
        ComponentName componentName = intent.getComponent();
        Intent mainIntent = Intent.makeRestartActivityTask(componentName);
        startActivity(mainIntent);
        System.exit(0);


    }


}