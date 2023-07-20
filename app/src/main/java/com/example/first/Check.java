package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Check extends AppCompatActivity {

    android.widget.TextView TextView;
    android.widget.TextView nameResult, heightResult, weightResult, targetWeightResult, BMI,selectedTime, weightSub;
    DBManager dbm;
    SQLiteDatabase sqlDB;

    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        setTitle("나의 BMI는?");
        selectedTime = findViewById(R.id.selectedTime);
        nameResult = findViewById(R.id.nameResult);
        heightResult = findViewById(R.id.heightResult);
        weightResult = findViewById(R.id.weightResult);
        targetWeightResult=findViewById(R.id.targetWeightResult);
        BMI = findViewById(R.id.BMI);
        weightSub = findViewById((R.id.weightSub));


        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();
        String name = bundle.getString("name").toString();
        String selected_time = bundle.getString("time_set").toString();
        String height; //= bundle.getString("height").toString();
        String weight; //= bundle.getString("weight").toString();
        String targetWeight; //= bundle.getString("targetWeight").toString();
        //String selected_time; //= bundle.getString("selected_time").toString();
        //String weightSub = bundle.getString("weightSub").toString();

       /* nameResult.setText(name+"님의 정보");
        heightResult.setText("키 : " + height+"cm");
        weightResult.setText("몸무게 : " + weight+"kg");
        targetWeightResult.setText("목표체중 : " + targetWeight+"kg");
        //selectedTime.setText("기상 시간 : "+ mHour +"시 "+ mMinute+"분");
        float typecast;
        typecast = Float.parseFloat(height);
        double sqrt = Math.pow((typecast/100),2);

        typecast = Float.parseFloat(weight);
        double bmi = typecast / sqrt;
        //DecimalFormat format = new DecimalFormat("#.##0");
        //String ret = format.format(bmi);
        BMI.setText(String.format("BMI : %.2f", bmi ));
        selectedTime.setText("기상 시간 : "+ selected_time);
        float typecast2, typecast3;
        typecast2 = Float.parseFloat(weight);
        typecast3= Float.parseFloat(targetWeight);
        float sub = typecast2 - typecast3;
        weightSub.setText("목표체중까지 "+sub+"kg 남았습니다.\n"+name+"님의 정보가 맞나요?");*/

        try{
            dbm = new DBManager(this);
            sqlDB = dbm.getReadableDatabase();

            Cursor cur = sqlDB.query("person",null,"name=?", new String[]{name},null,null,null,null);

            if(cur.moveToFirst()){
                name = cur.getString(cur.getColumnIndex("name"));
                height = cur.getString(cur.getColumnIndex("height"));
                weight = cur.getString(cur.getColumnIndex("weight"));
                targetWeight = cur.getString(cur.getColumnIndex("target"));

                //selected_time = cur.getString(cur.getColumnIndex("wakeup"));
                nameResult.setText(name+"님의 정보");
                heightResult.setText("키 : " + height+"cm");
                weightResult.setText("몸무게 : " + weight+"kg");
                targetWeightResult.setText("목표체중 : " + targetWeight+"kg");
                selectedTime.setText("기상 시간 : "+ selected_time);
                float typecast;
                typecast = Float.parseFloat(height);
                double sqrt = Math.pow((typecast/100),2);

                typecast = Float.parseFloat(weight);
                double bmi = typecast / sqrt;

                BMI.setText(String.format("BMI : %.2f", bmi ));
                //selectedTime.setText("기상 시간 : "+ selected_time);
                float typecast2, typecast3;
                typecast2 = Float.parseFloat(weight);
                typecast3= Float.parseFloat(targetWeight);
                float sub = typecast2 - typecast3;
                String target_res = String.format("%.2f",sub);
                weightSub.setText("목표체중까지 "+target_res+"kg 남았습니다.\n"+name+"님의 정보가 맞나요?");
               // Toast.makeText(this, height+weight+targetWeight, Toast.LENGTH_SHORT).show();
                cur.close();
                sqlDB.close();
                dbm.close();
            }
            //Cursor cur = sqlDB.query("person",null,);
        }catch(SQLException e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }//end of catch
    }


   /* public void selectYes(View v){
        int id = v.getId();
        LinearLayout layout = (LinearLayout) v.findViewById(R.id.checkLayout);

        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
    }*/


    public void selectedNo(View v){
        //onBackPressed();
        finish();
    }

    //@Override
    //public void onBackPressed() {
    //    super.onBackPressed();
    //}

    public void selectedYes(View v){
        int id = v.getId();
        LinearLayout layout = (LinearLayout) v.findViewById(R.id.checkLayout);

        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
    }

    public void cannot(View v){
        int id = v.getId();
        LinearLayout ll = (LinearLayout) v.findViewById(R.id.LL);
        Intent it= new Intent(this, NotDo.class);
        startActivity(it);
    }
}