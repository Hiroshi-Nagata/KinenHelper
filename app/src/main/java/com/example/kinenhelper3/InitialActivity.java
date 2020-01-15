package com.example.kinenhelper3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InitialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);

        Button dateText = findViewById(R.id.button_time_stop_smoking);
        Date currentTime = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy'年'MM'月'dd'日'　H'時'mm'分'");
        dateText.setText(simpleDateFormat.format(currentTime));

        dateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogCalenderFragment dialogCalenderFragment = new DialogCalenderFragment();
                dialogCalenderFragment.show(getSupportFragmentManager(), "tagCalender");
            }
        });
    }

    public void setTextOnButton(String date) {
        Button dateText = findViewById(R.id.button_time_stop_smoking);
        dateText.setText(date);
    }

//    InitialData initialData = new InitialData();
//
//        initialData.setNicotine(5);
//        initialData.setNumberInBox(20);
//        initialData.setTar(4);
//        initialData.setTotalSmokingPeriod(40);
}
