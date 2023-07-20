package com.example.first;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements CalendarAdapter.OnItemListener{
    private TextView monthYearText;
    private RecyclerView calendarRecyclerView;
    private LocalDate selectedDate;
    public FrameLayout fragment;
    //TextView text;
    //RecyclerView te;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidgets();
        selectedDate = LocalDate.now();
        setMonthView();

        Intent it = getIntent();
        Bundle bundle = it.getExtras();

    }// end of onCreate


    private void initWidgets() {
        calendarRecyclerView = findViewById(R.id.calendar_RecyclerView);
        monthYearText = findViewById(R.id.monthYearTV);
        fragment = findViewById(R.id.setting);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void setMonthView() {
        monthYearText.setText(monthYearFromDate(selectedDate));
        ArrayList<String> daysInMonth = daysInMonthArray(selectedDate);

        CalendarAdapter calendarAdapter = new CalendarAdapter(daysInMonth, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),7);
        calendarRecyclerView.setLayoutManager(layoutManager);
        calendarRecyclerView.setAdapter(calendarAdapter);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private ArrayList<String> daysInMonthArray(LocalDate date) {
        ArrayList<String> daysInMonthArray = new ArrayList<>();
        YearMonth yearMonth = YearMonth.from(date);

        int daysInMonth = yearMonth.lengthOfMonth();

        LocalDate firstOfMonth = selectedDate.withDayOfMonth(1);
        int dayOfWeek = firstOfMonth.getDayOfWeek().getValue();
        for(int i=1; i<=42; i++){
            if(i <= dayOfWeek || i >daysInMonth +dayOfWeek){
                daysInMonthArray.add("");
            }
            else{
                daysInMonthArray.add(String.valueOf(i - dayOfWeek));
            }
        }
        return daysInMonthArray;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private String monthYearFromDate(LocalDate date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
        return date.format(formatter);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private String monthOfDayFromDate(LocalDate date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MMMM");
        return date.format(formatter);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void previousMonthAction(View view){
        selectedDate = selectedDate.minusMonths(1);
        setMonthView();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //empty_activity empty = new empty_activity();
        //transaction.replace(R.id.setting, empty);
        transaction.commit();

        //setSettingView();


    }

    private void setSettingView() {


        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        setting setting = new setting();
        transaction.replace(R.id.setting,null );
        transaction.commit();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void nextMonthAction(View view){
        selectedDate = selectedDate = selectedDate.plusMonths(1);
        setMonthView();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onItemClick(int position, String dayText, TextView day) {
        String set_click_day;
        if(dayText.equals("")){
            String message = "selected Date" + dayText +" "+monthYearFromDate(selectedDate);
           // Toast.makeText(this, message, Toast.LENGTH_LONG).show();

        }
        set_click_day = monthOfDayFromDate(selectedDate)+"-"+dayText+"일";
        /*DDBManager dbm = new DDBManager(this);
        SQLiteDatabase sqlDB = dbm.getWritableDatabase();
        ContentValues value = new ContentValues();
        set_click_day = monthOfDayFromDate(selectedDate)+"-"+dayText+"일";
        Toast.makeText(this, set_click_day, Toast.LENGTH_SHORT).show();
        value.put("c_day",set_click_day);
        long row = sqlDB.insert("cal",null,value);*/
        Bundle bundle = new Bundle();

        bundle.putString("click_event",set_click_day);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        setting setting = new setting();
        setting.setArguments(bundle);
        transaction.replace(R.id.setting, setting);
        transaction.commit();

    }


}