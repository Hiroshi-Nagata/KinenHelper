package com.example.kinenhelper3;

import java.util.TimerTask;

public class TimeCountTask extends TimerTask {
    private Time mTime;
    public TimeCountTask(Time time) {
        mTime = time;
    }

    public void run() {
        mTime.tick();
    }
}
