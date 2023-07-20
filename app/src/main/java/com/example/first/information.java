package com.example.first;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;


public class information extends AppCompatActivity {

    int mHour, mMinute;
    TextView mTxtTime;
    EditText input_name;
    EditText input_height;
    EditText input_weight;
    EditText input_targetWeight;
    private AlarmManager alarmManager;
    private NotificationManager notificationManager;
    NotificationCompat.Builder builder;
    SQLiteDatabase sqlDB;
    DBManager dbm;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        final TimePicker  picker = (TimePicker) findViewById(R.id.timePicker);
        picker.setIs24HourView(true);

        SharedPreferences sharedPreferences = getSharedPreferences("dialy alarm", MODE_PRIVATE);
        long millis = sharedPreferences.getLong("nextNotifyTime", Calendar.getInstance().getTimeInMillis());

        Calendar nextNotifyTime = new GregorianCalendar();
        nextNotifyTime.setTimeInMillis(millis);

        Date nextDate = nextNotifyTime.getTime();
        //String date_text = new SimpleDateFormat("yyyy년 MM월 dd일 EE요일 a hh시 mm분",Locale.getDefault()).format(nextDate);
        //Toast.makeText(getApplicationContext(),"[처음 실행시] 다음 알람은 "+ date_text+"으로 알람이 설정되었습니다.",Toast.LENGTH_SHORT).show();

        Date currentTime = nextNotifyTime.getTime();
        SimpleDateFormat HourFormat = new SimpleDateFormat("kk", Locale.getDefault());
        SimpleDateFormat MinuteFormat = new SimpleDateFormat("mm", Locale.getDefault());

        int pre_hour = Integer.parseInt(HourFormat.format(currentTime));
        int pre_minute = Integer.parseInt(MinuteFormat.format(currentTime));

        if(Build.VERSION.SDK_INT >= 23){
            picker.setHour(pre_hour);
            picker.setMinute(pre_minute);
        }
        else{
            picker.setCurrentHour(pre_hour);
            picker.setCurrentMinute(pre_minute);
        }

        Button button = (Button) findViewById(R.id.but1);
        //버튼 클릭 시
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int hour, hour_24, minute;
                String am_pm;
                if(Build.VERSION.SDK_INT >= 23){
                    hour_24 = picker.getHour();
                    minute = picker.getMinute();
                }
                else{
                    hour_24 = picker.getCurrentHour();
                    minute = picker.getCurrentMinute();
                }
                if(hour_24>12){
                    am_pm ="PM";
                    hour=hour_24 -12;
                }
                else{
                    hour=hour_24;
                    am_pm="AM";
                }
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                calendar.set(Calendar.HOUR_OF_DAY,hour_24);
                calendar.set(Calendar.MINUTE,minute);
                calendar.set(Calendar.SECOND,0);

                if(calendar.before(Calendar.getInstance())){
                    calendar.add(Calendar.DATE,1);
                }

                Date currentDateTime = calendar.getTime();
                //String date_text = new SimpleDateFormat("yyyy년 MM월 dd일 EE요일 a hh시 mm분", Locale.getDefault()).format(currentDateTime);
                //Toast.makeText(getApplicationContext(),date_text + "으로 알림이 설정되었습니다.", Toast.LENGTH_SHORT).show();


                SharedPreferences.Editor editor = getSharedPreferences("daily alarm", MODE_PRIVATE).edit();
                editor.putLong("nextNotifyTime", (long)calendar.getTimeInMillis());
                editor.apply();

                diaryNotification(calendar);


                //mTxtTime = findViewById(R.id.txttime);

                input_name = findViewById(R.id.name);
                input_height = findViewById(R.id.height);
                input_weight = findViewById(R.id.weight);
                input_targetWeight = findViewById(R.id.targetWeight);


                //mTxtTime =

                String time_set = picker.getHour() +"시"+ picker.getMinute()+"분";//mTxtTime.getText().toString();
                String name = input_name.getText().toString();
                String height = input_height.getText().toString();
                String weight = input_weight.getText().toString();
                String targetWeight = input_targetWeight.getText().toString();
               // Toast.makeText(getApplicationContext(),time_set,Toast.LENGTH_LONG).show();
                LinearLayout layout = (LinearLayout) findViewById(R.id.infor);



                try{
                    dbm = new DBManager(getApplicationContext());
                    sqlDB = dbm.getWritableDatabase();


                    ContentValues vals = new ContentValues();
                    vals.put("name", name);
                    vals.put("height",height);
                    vals.put("weight", weight);
                    vals.put("target",targetWeight);
                    //vals.put("wakeup", time_set);

                    long newRowId = sqlDB.insert("person",null, vals);
                    if (newRowId == -1)
                    {
                       // Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        //Toast.makeText(getApplicationContext(), "데이터 추가 성공", Toast.LENGTH_SHORT).show();
                    }
                    sqlDB.close();
                    dbm.close();
                    Intent intent = new Intent(getApplicationContext(), Check.class);
                    intent.putExtra("name", name);
                    intent.putExtra("time_set",time_set);


                    startActivity(intent);

                }catch(SQLException e){
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                }



            }
        });


        setTitle("정보입력");


    }


    /*
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void start1(View v){



        int hour_24;

        //mTxtTime = findViewById(R.id.txttime);
        input_name = findViewById(R.id.name);
        input_height = findViewById(R.id.height);
        input_weight = findViewById(R.id.weight);
        input_targetWeight = findViewById(R.id.targetWeight);
        //mTxtTime =

        //String time_set = mTxtTime.getText().toString();
        String name = input_name.getText().toString();
        String height = input_height.getText().toString();
        String weight = input_weight.getText().toString();
        String targetWeight = input_targetWeight.getText().toString();

        LinearLayout layout = (LinearLayout) v.findViewById(R.id.infor);



        try{
            dbm = new DBManager(this);
            sqlDB = dbm.getWritableDatabase();


            ContentValues vals = new ContentValues();
            vals.put("name", name);
            vals.put("height",height);
            vals.put("weight", weight);
            vals.put("target",targetWeight);
            //vals.put("wakeup", time_set);

            long newRowId = sqlDB.insert("person",null, vals);
            if (newRowId == -1)
            {
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, "데이터 추가 성공", Toast.LENGTH_SHORT).show();
            }
            sqlDB.close();
            dbm.close();
            Intent intent = new Intent(getBaseContext(), Check.class);
            intent.putExtra("name", name);
            //intent.putExtra("height", height);
            //intent.putExtra("weight", weight);
            //intent.putExtra("targetWeight", targetWeight);
            //intent.putExtra("selected_time",time_set);
            //intent.putExtra("mHour", mHour);
            //intent.putExtra("mMinute", mMinute);
            startActivity(intent);

        }catch(SQLException e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
        }


    }*/

        void diaryNotification(Calendar calendar){
            Boolean dailyNotify = true; //무조건 알림 사용

            PackageManager pm = this.getPackageManager();
            ComponentName receiver = new ComponentName(this, DeviceBootReceiver.class);
            Intent alarmIntent = new Intent(this, AlarmReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, alarmIntent,0);
            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            if(dailyNotify){
                if(alarmManager != null){
                    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);

                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                        alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(), pendingIntent);
                    }
                }
                pm.setComponentEnabledSetting(receiver, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
            }

        }
}