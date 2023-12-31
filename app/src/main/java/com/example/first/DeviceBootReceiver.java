package com.example.first;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Objects;

public class DeviceBootReceiver extends BroadcastReceiver {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onReceive(Context context, Intent intent) {

        if(Objects.equals(intent.getAction(), "android.intent.action.BOOT_COMPLETED")){
            Intent alarmIntent = new Intent(context, AlarmReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, alarmIntent, 0);

            AlarmManager manager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            SharedPreferences sharedPreferences= context.getSharedPreferences("daily alarm", Context.MODE_PRIVATE);
            long millis = sharedPreferences.getLong("nextNotifyTime", Calendar.getInstance().getTimeInMillis());

            Calendar current_calendar = Calendar.getInstance();
            Calendar nextNotifyTime = new GregorianCalendar();
            nextNotifyTime.setTimeInMillis(sharedPreferences.getLong("nextNotifyTime", millis));

            if(current_calendar.after(nextNotifyTime)){
                nextNotifyTime.add(Calendar.DATE,1);
            }

            Date currentDateTime = nextNotifyTime.getTime();
            String date_text = new SimpleDateFormat("yyyy년 MM월 dd일 EE요일 a hh시 mm분", Locale.getDefault()).format(currentDateTime);
           // Toast.makeText(context.getApplicationContext(), "[재부팅 후] 다음 알림은 "+ date_text+ "으로 알림이 설정되었습니다.", Toast.LENGTH_SHORT).show();

            if (manager != null){
                manager.setRepeating(AlarmManager.RTC_WAKEUP, nextNotifyTime.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
            }

        }
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}