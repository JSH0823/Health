package com.example.first;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class AlarmReceiver extends BroadcastReceiver {

    /*public AlarmReceiver(){}
        NotificationManager manager;
        NotificationCompat.Builder builder;

        String CHANNEL_ID ="channel1";
        String CHANNEL_NAME= "Channel1";*/


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Intent notificationIntent = new Intent(context, MainActivity.class);

        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pendingI = PendingIntent.getActivity(context, 0, notificationIntent,0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "default");

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            builder.setSmallIcon(R.drawable.ic_launcher_foreground);

            String channelName = "매일 알람  채널";
            String description = "매일 정해진 시간에 알람합니다.";
            int importance  = NotificationManager.IMPORTANCE_HIGH;

            NotificationChannel channel = new NotificationChannel("default", channelName, importance);
            channel.setDescription(description);
            if(notificationManager != null){
                notificationManager.createNotificationChannel(channel);
            }
        }
        else{
            builder.setSmallIcon(R.mipmap.ic_launcher);
        }
        builder.setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())

                .setTicker("{Time to watch some cool stuff!}")
                .setContentTitle("Diet Manager")
                .setContentText("어제 하루 점검할 시간입니다.")
                .setContentInfo("INFO")
                .setContentIntent(pendingI);
        if(notificationManager != null){
            notificationManager.notify(1234, builder.build());

            Calendar nextNotifyTime = Calendar.getInstance();

            //내일 같은 시간으로 알람시간 결정
            nextNotifyTime.add(Calendar.DATE,1);
            //preference에 설정한 값 저장
            SharedPreferences.Editor editor = context.getSharedPreferences("daily alarm", Context.MODE_PRIVATE).edit();
            editor.putLong("nextNotifyTime", nextNotifyTime.getTimeInMillis());
            editor.apply();

            Date currentDateTime = nextNotifyTime.getTime();
            String date_text = new SimpleDateFormat("yyyy년 MM월 dd일 EE요일 a hh시 mm분", Locale.getDefault()).format(currentDateTime);
            //.makeText(context.getApplicationContext(), "다음 알람은 "+ date_text+"으로 설정되었습니다.", Toast.LENGTH_SHORT).show();

        }
        /*
        AlarmManager am  = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        builder = null;
        manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            manager.createNotificationChannel(
                    new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT)
            );
            builder = new NotificationCompat.Builder(context, CHANNEL_ID);
        } else {
           // builder = new NotificationCompat.Builder(context);
        }
        //알림창 클릭 시 activity 화면 부름
        Intent intent2 = new Intent(context, Intro.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(context,0,intent2, PendingIntent.FLAG_UPDATE_CURRENT);
        try {
            pendingIntent.send();
        } catch (PendingIntent.CanceledException e) {
            e.printStackTrace();
        }
        //알림창 제목
        builder.setContentTitle("알람");
        //알림창 아이콘
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        //알림창 터치시 자동 삭제
        builder.setAutoCancel(true);

        builder.setContentIntent(pendingIntent);

        Notification notification = builder.build();
        manager.notify(1,notification);
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        throw new UnsupportedOperationException("Not yet implemented");
        */
    }
}