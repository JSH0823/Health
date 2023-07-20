package com.example.first;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

public class CalendarViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public  final TextView dayOfMonth;
    private final CalendarAdapter.OnItemListener onItemListener;


    public CalendarViewHolder(@NonNull View itemView, CalendarAdapter.OnItemListener onItemListener) {
        super(itemView);
        dayOfMonth = itemView.findViewById(R.id.cellDayText);
        this.onItemListener = onItemListener;
        itemView.setOnClickListener(this);



    }
    public void onClick(View view){
        onItemListener.onItemClick(getAdapterPosition(),(String) dayOfMonth.getText(), (TextView) dayOfMonth);
    }
}