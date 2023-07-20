package com.example.first;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class check_eat extends Fragment {
    private View view;
    //private Button mor,lun,din, notButton;
    private TextView today;
    private String result,day;
    private SQLiteDatabase sqlDB;
    private DDBManager dbm;
    private TextView ch1,ch2,ch3;
    private RadioGroup ek1,ek2,ek3;
    private RadioButton e_ek1,e_ek2,e_ek3,e_ek4,e_ek5,e_ek6;
    private Button checkUpdate;
    int res = 0;
    private int promise = 0, point=0;

    public void checkRadio(RadioGroup r){


        r.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                //Toast.makeText(getActivity(),"식단 지킨 횟수 : "+promise,Toast.LENGTH_LONG).show();
                point = 0;
                if(i == R.id.e_ek1){
                    point++;
                    promise += point;
                }
                else if(i == R.id.e_ek3){
                    point++;
                    promise += point;
                }
                else if(i == R.id.e_ek5){
                    point++;
                    promise += point;
                }

                //Toast.makeText(getActivity(),"식단 지킨 횟수 : "+promise,Toast.LENGTH_LONG).show();
            }

        });


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.check_eat, container, false);
        //notButton = view.findViewById(R.id.notButton);
        ch1 = view.findViewById(R.id.mor);
        ch2 = view.findViewById(R.id.lun);
        ch3 = view.findViewById(R.id.din);
        //RadoiGroup
        ek1 = view.findViewById(R.id.r1);
        ek2 = view.findViewById(R.id.r2);
        ek3 = view.findViewById(R.id.r3);

        /*e_ek1 = view.findViewById(R.id.e_ek1);
        e_ek2 = view.findViewById(R.id.e_ek2);
        e_ek3 = view.findViewById(R.id.e_ek3);
        e_ek4 = view.findViewById(R.id.e_ek4);
        e_ek5 = view.findViewById(R.id.e_ek5);

        e_ek6 = view.findViewById(R.id.e_ek6);
*/
        checkUpdate = view.findViewById(R.id.CU);

        dbm = new DDBManager(getActivity());
        sqlDB = dbm.getReadableDatabase();
        Bundle bundle = getArguments();
        day = bundle.getString("fragment");

        //String sql = new StringBuilder().append("SELECT breakfast FROM cal WHERE c_day = '?'").append(day).toString();
        //Cursor cur = dbm.getReadableDatabase().rawQuery(sql, null);
        Cursor cur = sqlDB.rawQuery("SELECT breakfast FROM cal WHERE c_day = ?", new String[] {day});
        if(cur.moveToFirst()){
            String breakfast = cur.getString(0);
            ch1.setTextSize(14);
            ch1.setText(breakfast);

            //Toast.makeText(getActivity(), breakfast, Toast.LENGTH_SHORT).show();
        }

        //sql = "SELECT lunch FROM cal";
        //cur = dbm.getReadableDatabase().rawQuery(sql, null);
        cur = sqlDB.rawQuery("SELECT lunch FROM cal WHERE c_day = ?", new String[] {day});
        if(cur.moveToFirst()){
            String lunch = cur.getString(0);
            ch2.setTextSize(14);
            if(lunch != null)  ch2.setText(lunch);
        }

        //sql = "SELECT dinner FROM cal";
        //cur = dbm.getReadableDatabase().rawQuery(sql, null);
        cur = sqlDB.rawQuery("SELECT dinner FROM cal WHERE c_day = ?", new String[] {day});
        if(cur.moveToFirst()){
            String dinner = cur.getString(0);
            ch3.setTextSize(14);
            if(dinner != null)  ch3.setText(dinner);
        }

        cur.close();
        sqlDB.close();
        dbm.close();


        today = view.findViewById(R.id.day2);
        result = getArguments().getString("fragment");
        today.setText("오늘의 식단 "+result);
        if(getArguments() != null){
            result = getArguments().getString("fragment"); //putString 한 값을 가져온다.
            //today.setText(result.toString());
        }
        //checkRadio(ek1);
        //Toast.makeText(getActivity(),"식단 지킨 횟수 : "+checkRadio(ek1),Toast.LENGTH_LONG).show();
        checkRadio(ek1);
        checkRadio(ek2);
        checkRadio(ek3);


        checkUpdate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

              //  Toast.makeText(getActivity(),"promise : "+promise,Toast.LENGTH_LONG).show();

                DDBManager DDbm = new DDBManager(getActivity());
                SQLiteDatabase sqlDDB = DDbm.getWritableDatabase();
                ContentValues pro = new ContentValues();
                pro.put("promise",promise);
                //String sqlUpdate = "SELECT promise FROM cal WHERE c_day = ? ";
                long sqlUpdate = sqlDDB.update("cal",pro,"c_day=?",new String[]{result});

            }
        });

        return view;


    }




}
