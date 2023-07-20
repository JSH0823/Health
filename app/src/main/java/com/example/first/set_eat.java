package com.example.first;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class set_eat extends Fragment {
    private View view;
    private String result;
    private TextView today,morning,lunch,dinner;
    public String sel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.set_eat, container, false);
        today = view.findViewById(R.id.day);
        morning = view.findViewById(R.id.morning);
        lunch = view.findViewById(R.id.lunch);
        dinner = view.findViewById(R.id.dinner);
        result = getArguments().getString("fragment");
        today.setText(result);

        if(getArguments() != null){
            result = getArguments().getString("fragment"); //putString 한 값을 가져온다.
            //today.setText(result.toString());
        }

        morning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("fragment", "breakfast");
                bundle.putString("day",today.getText().toString());
                sel = "breakfast";
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                list_eat listEat = new list_eat();
                listEat.setArguments(bundle);
                transaction.replace(R.id.list, listEat);
                transaction.commit();
            }
        });

        lunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("fragment", "lunch");
                sel = "lunch";
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                list_eat listEat = new list_eat();
                listEat.setArguments(bundle);
                transaction.replace(R.id.list, listEat);
                transaction.commit();
            }
        });

        dinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("fragment", "dinner");
                sel = "dinner";
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                list_eat listEat = new list_eat();
                listEat.setArguments(bundle);
                transaction.replace(R.id.list, listEat);
                transaction.commit();
            }
        });

        return view;
    }
}