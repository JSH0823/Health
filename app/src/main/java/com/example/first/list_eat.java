package com.example.first;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class list_eat extends Fragment {
    private View view;
    private String breakfast, lunch, dinner;
    private String sweet= "고구마", chick="닭가슴살", apple="사과", rice="현미밥";
    private String SW,ChW,AW,RW,EW;
    private RadioGroup group_sweet;
    private RadioGroup group_chick;
    private RadioGroup group_rice,group_apple;
    private RadioGroup group_etc;
    private RadioButton sweetRadio1,sweetRadio2,sweetRadio3;
    private RadioButton chickRadio1, chickRadio2,chickRadio3;
    private RadioButton appleRadio1, appleRadio2,appleRadio3;
    private RadioButton riceRadio1, riceRadio2,riceRadio3;
    private RadioButton etcRadio1,etcRadio2,etcRadio3;
    private CheckBox s,c,a,r,e;
    private EditText ppp;
    private Button set;
    private DDBManager dbm;
    private SQLiteDatabase sqlDB;
    private String res = " ",moment;
    private String today;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.list_eat, container, false);

        Bundle bundle = getArguments();
        moment = bundle.getString("fragment");
        today = bundle.getString("day");
        set = view.findViewById(R.id.eat_setting);
        //Toast.makeText(getActivity(), today, Toast.LENGTH_SHORT).show();
        s = view.findViewById(R.id.s);
        c = view.findViewById(R.id.c);
        a = view.findViewById(R.id.a);
        r = view.findViewById(R.id.r);
        e = view.findViewById(R.id.e);

        group_sweet =  view.findViewById(R.id.group_sweet);
        group_chick = view.findViewById(R.id.group_chick);
        group_apple = view.findViewById(R.id.group_apple);
        group_rice = view.findViewById(R.id.group_rice);
        group_etc = view.findViewById(R.id.group_etc);

        sweetRadio1 = view.findViewById(R.id.little1);
        sweetRadio2 = view.findViewById(R.id.middle1);
        sweetRadio3 = view.findViewById(R.id.much1);

        chickRadio1 = view.findViewById(R.id.little2);
        chickRadio2 = view.findViewById(R.id.middle2);
        chickRadio3 = view.findViewById(R.id.much2);

        appleRadio1 = view.findViewById(R.id.little3);
        appleRadio2 = view.findViewById(R.id.middle3);
        appleRadio3 = view.findViewById(R.id.much3);

        riceRadio1 = view.findViewById(R.id.little4);
        riceRadio2 = view.findViewById(R.id.middle4);
        riceRadio3 = view.findViewById(R.id.much4);

        etcRadio1 = view.findViewById(R.id.little5);
        etcRadio2 = view.findViewById(R.id.middle5);
        etcRadio3 = view.findViewById(R.id.much5);

        ppp = view.findViewById(R.id.pip);


        group_sweet.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.little1){
                    //sweetRadio1.setText("선택됨1");
                    SW = sweetRadio1.getText().toString();
                }else if(i == R.id.middle1){
                    //sweetRadio2.setText("선택됨2");
                    SW = sweetRadio2.getText().toString();
                }else if(i == R.id.much1){
                    //sweetRadio3.setText("선택됨3");
                    SW = sweetRadio3.getText().toString();
                }
            }
        });

        group_chick.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int j) {
                if(j == R.id.little2){
                    //chickRadio1.setText("선택됨4");
                    ChW = chickRadio1.getText().toString();
                }else if(j == R.id.middle2){
                    //chickRadio2.setText("선택됨5");
                    ChW = chickRadio2.getText().toString();
                }else if(j == R.id.much2){
                    //chickRadio3.setText("선택됨6");
                    ChW = chickRadio3.getText().toString();
                }
            }
        });
        group_apple.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int j) {
                if(j == R.id.little3){
                   // appleRadio1.setText("선택됨7");
                    AW = appleRadio1.getText().toString();
                }else if(j == R.id.middle3){
                   // appleRadio2.setText("선택됨8");
                    AW = appleRadio2.getText().toString();
                }else if(j == R.id.much3){
                   // appleRadio3.setText("선택됨9");
                    AW = appleRadio3.getText().toString();
                }
            }
        });
        group_rice.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int j) {
                if(j == R.id.little4){
                    //riceRadio1.setText("선택됨10");
                    RW = riceRadio1.getText().toString();
                }else if(j == R.id.middle4){
                    //riceRadio2.setText("선택됨11");
                    RW = riceRadio2.getText().toString();
                }else if(j == R.id.much4){
                    //riceRadio3.setText("선택됨12");
                    RW = riceRadio3.getText().toString();
                }
            }
        });

        group_etc.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int j) {
                if(j == R.id.little5){
                    //etcRadio1.setText("선택됨13");
                    EW = etcRadio1.getText().toString();
                }else if(j == R.id.middle5){
                    //etcRadio2.setText("선택됨14");
                    EW = etcRadio2.getText().toString();
                }else if(j == R.id.much5){
                    //etcRadio3.setText("선택됨15");
                    EW = etcRadio3.getText().toString();
                }
            }
        });

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dbm = new DDBManager(getActivity());
                sqlDB = dbm.getWritableDatabase();
                String etc_menu = ppp.getText().toString();
                if(s.isChecked()){
                    res += "고구마 : " + SW+ "\n";
                }
                if(c.isChecked()){
                    res += "닭가슴살 : " + ChW+"\n";
                }
                if(a.isChecked()){
                    res += "사과 : " +AW +"\n";
                }
                if(r.isChecked()){
                    res += "현미밥 : " + RW+"\n";
                }
                if(e.isChecked()){
                    res += etc_menu+" : " + EW+"\n";
                }

                //Toast.makeText(getActivity(), moment, Toast.LENGTH_SHORT).show();
                //ContentValues val1 = new ContentValues();
                //Toast.makeText(getActivity(), today, Toast.LENGTH_SHORT).show();
                //val1.put("c_day",today);
                //long RowId = sqlDB.insert("cal",null,val1);
                ContentValues val2 = new ContentValues();
                val2.put(moment,res);
                long newRowId = sqlDB.update("cal",val2,null,null);
                if (newRowId == -1)
                {
                    //Toast.makeText(getActivity(), "Failed", Toast.LENGTH_SHORT).show();
                }
                else
                {
                   // Toast.makeText(getActivity(), "데이터 추가 성공", Toast.LENGTH_SHORT).show();
                }
                sqlDB.close();
                dbm.close();

            }
        });


        return view;
    }
    //public void
    // 아침, 점심, 저녁마다 체크된 체크박스 메뉴를 데이터베이스에 저장
    // 이것이 check_eat 이 열렸을때 아침, 점심, 저녁에 메뉴가 뜸
    public void click_set(View v){

    }
}