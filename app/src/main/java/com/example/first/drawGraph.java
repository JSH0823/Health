package com.example.first;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class drawGraph extends AppCompatActivity {
    private LineChart lineChart;
    private ProgressBar pro;
    private TextView suc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_graph);
        pro = findViewById(R.id.progressBar);
        suc = findViewById(R.id.success);

        Intent it = getIntent();
        Bundle bundle = it.getExtras();

        setTitle("평가");


        int meal_num = bundle.getInt("meal");
        //Toast.makeText(this,""+meal_num,Toast.LENGTH_SHORT).show();
        lineChart = (LineChart)findViewById(R.id.chart);
        DDBManager dbm = new DDBManager(this);
        Cursor c = dbm.getReadableDatabase().rawQuery("SELECT day_weight FROM cal",null);
        c.moveToFirst();
        String test = c.getString(0);
        int i= 1;
        List<Entry> entries = new ArrayList<>();
        entries.add(new Entry(i,Float.valueOf(test)));
        //Toast.makeText(this,test,Toast.LENGTH_SHORT).show();
        while(c.moveToNext()){
            i++;
            //c.moveToNext();
            test = c.getString(0);
            entries.add(new Entry(i,Float.valueOf(test)));
            //Toast.makeText(this,test,Toast.LENGTH_SHORT).show();
        }

        c = dbm.getReadableDatabase().rawQuery("SELECT promise FROM cal",null);
        c.moveToFirst();
        int s=0;
        s+= c.getInt(0);
        while(c.moveToNext()){
            s+= c.getInt(0);
        }
        //Toast.makeText(this,""+s,Toast.LENGTH_SHORT).show();
        c.close();
        dbm.close();
        //List<Entry> entries = new ArrayList<>();
        //entries.add(new Entry(1,1));
        //entries.add(new Entry(2,2));
        //entries.add(new Entry(3,0));
        //entries.add(new Entry(4,4));
        //entries.add(new Entry(5,3));

        LineDataSet lineDataSet = new LineDataSet(entries,"속성명 1");
        lineDataSet.setLineWidth(2);
        lineDataSet.setCircleRadius(7);
        lineDataSet.setCircleColor(Color.parseColor("#FFA1B4DC"));
        lineDataSet.setCircleHoleColor(Color.BLUE);
        lineDataSet.setColor(Color.parseColor("#FFA1B4DC"));
        lineDataSet.setDrawCircleHole(true);
        lineDataSet.setDrawCircles(true);
        lineDataSet.setDrawHorizontalHighlightIndicator(false);
        lineDataSet.setDrawHighlightIndicators(false);
        lineDataSet.setDrawValues(false);

        LineData lineData = new LineData(lineDataSet);
        lineChart.setData(lineData);

        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextColor(Color.BLACK);
        xAxis.enableGridDashedLine(8, 21, 0);

        YAxis yLAxis = lineChart.getAxisLeft();
        yLAxis.setTextColor(Color.BLACK);

        YAxis yRAxis = lineChart.getAxisRight();
        yRAxis.setDrawLabels(false);
        yRAxis.setDrawAxisLine(false);
        yRAxis.setDrawGridLines(false);

        Description description = new Description();
        description.setText("");

        lineChart.setDoubleTapToZoomEnabled(false);
        lineChart.setDrawGridBackground(false);
        lineChart.setDescription(description);
        lineChart.animateY(2000, Easing.EaseInCubic);
        lineChart.invalidate();


        float ret =  Float.valueOf(s)/(Float.valueOf(meal_num) )*100;
        String ret_str = String.format("%.2f",ret);
        suc.setText("식단 성공률 : "+ ret_str+"%");
        pro.setMax(meal_num);
        pro.setProgress(s);




    }
    public void goBackMain(View v){
        int id = v.getId();
        LinearLayout layout = (LinearLayout) v.findViewById(id);

        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
    }

    }
