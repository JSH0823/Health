package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class reSet extends AppCompatActivity {
    private EditText tar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re_set);
        setTitle("목표체중 재설정");
    }
    public void goBackMain1(View v){
        tar = findViewById(R.id.re_target);
        String target = tar.getText().toString();


        DBManager dbm = new DBManager(this);
        SQLiteDatabase sqlDB = dbm.getWritableDatabase();
        ContentValues tar_val = new ContentValues();
        tar_val.put("target",target);
        long raw = sqlDB.update("person",tar_val,null,null);
        //Toast.makeText(this, "목표 몸무게 재 설정 : "+target, Toast.LENGTH_SHORT).show();
        sqlDB.close();
        dbm.close();


        int id = v.getId();
        LinearLayout layout = (LinearLayout) v.findViewById(id);

        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
    }
}