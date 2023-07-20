package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.system.ErrnoException;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Yesterday extends AppCompatActivity {


    int mHour, mMinute;
    TextView mTxTTime;
    EditText input_name;
    EditText input_height;
    EditText input_weight;
    EditText input_targetWeight;
    android.widget.TextView evaluation, weight;
    RadioButton ya_yes, ya_no;
    private Button okay;
    private String today_weight,today;
    private SQLiteDatabase sqlDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yesterday);
        Intent it = getIntent();
        today = it.getExtras().getString("today");
        okay = findViewById(R.id.okay);


        //Toast.makeText(this,"where = "+today,Toast.LENGTH_LONG).show();
        //텍스트뷰 연결
        //mTxTTime = (TextView)findViewById(R.id.txttime);

        //현재 시간을 가져오기 위한 Calendar 인스턴스 선언
       // Calendar cal = new GregorianCalendar();
       // mHour = cal.get(Calendar.HOUR_OF_DAY);
       // mMinute = cal.get(Calendar.MINUTE);

        //화면에 텍스트뷰에 업데이트 해줌
    }



    public void setEvaluation(View v){
        evaluation = findViewById(R.id.evaluation);
        input_weight = findViewById(R.id.weight);
        //weight = (EditText)findViewById(R.id.weight);
        ya_yes = findViewById(R.id.little);
        ya_no = findViewById(R.id.middle);

        today_weight = input_weight.getText().toString();
        DDBManager dbm = new DDBManager(this);
        sqlDB = dbm.getWritableDatabase();
        ContentValues w = new ContentValues();
        w.put("day_weight", today_weight);
        String[] args = new String[]{today};
        long sql_q = sqlDB.update("cal",w,"c_day=?",new String[]{today});
        sqlDB.close();
        dbm.close();

        //Intent it = getIntent();
        //weight.getText().toString();
        //Integer.parseInt(weight.getText().toString());
        DBManager dbmR = new DBManager(this);
        SQLiteDatabase sqlR = dbmR.getReadableDatabase();
        Cursor cur = sqlR.rawQuery("SELECT weight,target FROM person",null);
        evaluation.setTextSize(25);
        if(cur.moveToFirst()){
            String first_weight = cur.getString(0);
            //Toast.makeText(this, first_weight, Toast.LENGTH_SHORT).show();
            if(Float.valueOf(first_weight)  > Float.valueOf(today_weight)){
                evaluation.setText("정말 잘하셨군요! 오늘도 파이팅!");
            }
            else{

                evaluation.setText("조금 아쉽군요..! 조금 더 힘내봐요!");
            }
            if (Float.valueOf(cur.getString(1))  >= Float.valueOf(today_weight)){
                Intent con = new Intent(this, Congratulation.class);
                startActivity(con);
            }

        }
        cur.close();
        sqlR.close();
        dbmR.close();
        /*dbm = new DDBManager(this);
        Cursor cur1 = dbm.getReadableDatabase().rawQuery("SELECT * FROM cal",null);
        cur1.moveToFirst();
        if(cur1.getCount() > 0){
            Toast.makeText(this,"count",Toast.LENGTH_LONG);
        }*/

    }
    public void setOkay(View v){
        DDBManager dbmR1 = new DDBManager(this);

        String sql_query = "SELECT day_weight FROM cal";
        Cursor curR = dbmR1.getReadableDatabase().rawQuery(sql_query,null);
        curR.moveToFirst();
        int i=0;
        String std = curR.getString(0);
        i=curR.getCount();
       // Toast.makeText(this, std+i, Toast.LENGTH_SHORT).show();
        curR.moveToNext();
        std = curR.getString(0);
        curR.close();
        dbmR1.close();
        try {
            if(i %7 == 0){
                Intent it = new Intent(this, drawGraph.class);
                Bundle bundle = new Bundle();
                bundle.putInt("meal",i*3);
                it.putExtras(bundle);
                startActivity(it);
                finish();
            }else{
                Intent it = new Intent(this, MainActivity.class);
                startActivity(it);
            }
        } catch (Exception e){
            Intent it = new Intent(this, MainActivity.class);
            startActivity(it);
        }






    }


}
