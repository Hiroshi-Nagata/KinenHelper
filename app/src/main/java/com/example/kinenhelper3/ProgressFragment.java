package com.example.kinenhelper3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.Timer;

public class ProgressFragment extends Fragment {

    //一定時間毎にタスクを起動するTimer
    private Timer mTimer;
    //Timerから一定時間毎に起動されるタスク
    private TimeCountTask mTimeCountTask;
    //秒数を保管するオブジェクト
    private Time mTime;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_progress, container, false);
        TextView textView = view.findViewById(R.id.text_cheering_message);
        return view;
    }

    private void changeDisplayMessage(String message) {
        Timer timer = new Timer(true);
        Time time = new Time();
    }

    private void timerStart() {
        if (mTimeCountTask == null) {
            mTimeCountTask = new TimeCountTask(mTime);
        }
        mTimer.schedule(mTimeCountTask, 0, 4000);
    }

    private void timerStop() {
        mTimeCountTask.cancel();
        mTimeCountTask = null;
    }

}
