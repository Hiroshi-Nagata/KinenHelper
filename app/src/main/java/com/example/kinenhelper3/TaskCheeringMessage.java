package com.example.kinenhelper3;

import android.widget.TextView;

import java.util.TimerTask;

public class TaskCheeringMessage extends TimerTask {

    String [] string = {"aaa","bbb"};
    int count = 0;
    TextView textView;
    TaskCheeringMessage(TextView textView) {
        this.textView = textView;
    }

    public void run() {

        if (count == 0) {
            count = 1;
        } else {
            count = 0;
        }
        textView.setText(string[count]);
    }
}