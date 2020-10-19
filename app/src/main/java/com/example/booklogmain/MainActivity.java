package com.example.booklogmain;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button bookshelf;
    CalendarView logDate;
    TextView dateShow;
    Button log;
    Switch switcher;
    int myYear, myMonth, myDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bookshelf = findViewById(R.id.bookshelf);
        logDate = findViewById(R.id.logDate);
        dateShow = findViewById(R.id.dateShow);
        log = findViewById(R.id.log);
        switcher = findViewById(R.id.switcher);
        //go to bookshelf
        bookshelf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mintent = new Intent(getApplicationContext(), Booklog_shelf.class);
                startActivity(mintent);
            }
        });
        //click switch to show/hide calendar
        switcher.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    logDate.setVisibility(View.VISIBLE);
                }else {
                    logDate.setVisibility(View.INVISIBLE);
                }
            }
        });
        //get calander infos when decided
        logDate.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                myYear = year;
                myMonth = month+1;// start from 0
                myDate = dayOfMonth;

            }
        });
        //click btn to log date
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dateShow.setText(myYear+"-"+myMonth+"-"+myDate);
            }
        });

    }
}
