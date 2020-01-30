package com.example.kinenhelper3;

import android.os.Handler;
import android.widget.TextView;

import java.util.TimerTask;

public class TaskCheeringMessage extends TimerTask {

    String[] string = {"aaa", "bbb"};
    int count = 0;
    TextView textView;
//    MainActivity mMainActivity = new MainActivity();

    TaskCheeringMessage(TextView textView) {
        this.textView = textView;
    }

    final Handler handler = new Handler();


    public void run() {

        if (count == 0) {
            count = 1;
        } else {
            count = 0;
        }
        textView.setText(string[count]);
    }

}