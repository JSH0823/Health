package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class NotDo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_do);
        setTitle("지키지 못했나요?");

        Intent it = getIntent();
    }

   public void goMain(View v){
        int id = v.getId();
        LinearLayout layout = (LinearLayout) v.findViewById(R.id.don);

        Intent it = new Intent(this, check_eat.class); //달력 메인화면으로 이동, 클래스 이름 고치기
        startActivity(it);
    }
}