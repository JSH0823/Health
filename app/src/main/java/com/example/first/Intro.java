package com.example.first;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

//import com.bumptech.glide.Glide;

import java.util.logging.Handler;

public class Intro extends AppCompatActivity {
    DBManager dbm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        Intent it = getIntent();
        ActionBar bar = getSupportActionBar();
        bar.hide();

    }


    public void start(View v) {
        dbm = new DBManager(this);
        String sql = "SELECT * FROM person";
        Cursor cur = dbm.getReadableDatabase().rawQuery(sql, null);
        cur.moveToFirst();
        if (cur.getCount() > 0) {
           // Toast.makeText(this, "exists database", Toast.LENGTH_LONG).show();
            Intent it = new Intent(this, MainActivity.class);
            cur.close();
            dbm.close();

            startActivity(it);
            finish();
        } else {
           // Toast.makeText(this, " Not exists database", Toast.LENGTH_LONG).show();
            int id = v.getId();
            LinearLayout layout = (LinearLayout) v.findViewById(id);

            Intent it = new Intent(this, information.class);
            startActivity(it); // 데이터베이스에 정보가  없다면 정보입력창으로 전환
            //데이터베이스에 정보가 있다면 메인화면(달력)창으로 전환
        }
    }
}