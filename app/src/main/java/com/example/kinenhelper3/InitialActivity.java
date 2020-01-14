package com.example.kinenhelper3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InitialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);

        Button dateText = findViewById(R.id.button_time_stop_smoking);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy'年'MM'月'dd'日'　H'時'mm'分'");
        dateText.setText(simpleDateFormat.format(date));

        TextView initial = findViewById(R.id.initial);

        InitialData initialData = new InitialData();
        initialData.setSmokingNum(20);
        int i = initialData.getSmokingNum();

        String string = String.valueOf(i);
        initial.setText(string);

        initialData.setNicotine(5);
        initialData.setNumberInBox(20);
        initialData.setTar(4);
        initialData.setTotalSmokingPeriod(40);


    }
}
