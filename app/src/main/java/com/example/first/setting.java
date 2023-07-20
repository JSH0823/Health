package com.example.first;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class setting extends Fragment {
    private View view;
    private Button btn_1, btn_2;
    private TextView click_day, bucket;
    private String click_value;
    private Button go_yesterday;
    public setting(){

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.setting, container, false);

        btn_1 = view.findViewById(R.id.btn_1); //fragment 에서는 findById 할때 view.으로 접근해야함
        btn_2 = view.findViewById(R.id.btn_2);
        click_day = view.findViewById(R.id.clickDay);
        go_yesterday = view.findViewById(R.id.go_yesterday);
        click_value = getArguments().getString("click_event");

        click_day.setText(click_value);


        btn_2.setOnClickListener(new View.OnClickListener() {//식단설정, 평가이동 //실험용으론 empty_activity로 이동
            @Override
            public void onClick(View view) {//빈화면 출력
                Bundle  bundle = new Bundle(); // 무언가를 담을 준비를 할수 있는 보따리
                bundle.putString("fragment", click_value);//날짜
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction(); //tranasction은 fragment 들을 관리할 도구
                check_eat checkEat = new check_eat();
                checkEat.setArguments(bundle);
                transaction.replace(R.id.setting, checkEat);
                transaction.commit();
            }

        });

        btn_1.setOnClickListener(new View.OnClickListener() {
            DDBManager dbm = new DDBManager(getActivity());
            SQLiteDatabase sqlDB = dbm.getWritableDatabase();
            ContentValues val1 = new ContentValues();
            @Override
            public void onClick(View view) {
                //Toast.makeText(getActivity(), today, Toast.LENGTH_SHORT).show();
                //Toast.makeText(getActivity(), click_value, Toast.LENGTH_SHORT).show();
                val1.put("c_day",click_value);
                long rowDay = sqlDB.insert("cal",null, val1);
                Bundle bundle = new Bundle();

                sqlDB.close();
                dbm.close();

                bundle.putString("fragment", click_value);
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                set_eat setEat = new set_eat();
                setEat.setArguments(bundle);
                transaction.replace(R.id.setting, setEat);
                transaction.commit();
            }
        });

        go_yesterday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getActivity(),Yesterday.class);
                it.putExtra("today",click_value);
                startActivity(it);
            }
        });
        return view;
    }

}