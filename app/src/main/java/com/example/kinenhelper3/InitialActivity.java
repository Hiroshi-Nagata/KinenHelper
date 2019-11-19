package com.example.kinenhelper3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class InitialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);

        InitialData initialData = new InitialData();
        initialData.setSmokingNum(20);
        initialData.setNicotine(5);
        initialData.setNumberInBox(20);
        initialData.setTar(4);
        initialData.setTotalSmokingPeriod(40);
    }
}
