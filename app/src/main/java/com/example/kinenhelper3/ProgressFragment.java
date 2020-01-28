package com.example.kinenhelper3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.Timer;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class ProgressFragment extends Fragment {

    //一定時間毎にタスクを起動するTimer
    private Timer mTimer;
    //Timerから一定時間毎に起動されるタスク
    private TimeCountTask mTimeCountTask;
    //秒数を保管するオブジェクト
    private Time mTime;

    private Realm mRealm;
    private RealmQuery<InitialData> mRealmQuery;
    private RealmResults<InitialData> mRealmResults;
    private InitialData mInitialData;

    private int mNumberOfSmokingOnDay;
    private int mTotalSmokingPeriod;
    private TextView mTextTimeNonSmokingPeriod;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_progress, container, false);
        setCumulativeNumberOfSmoking(view);
        return view;
    }

    private void setRealm() {
        mRealm = Realm.getDefaultInstance();
        mRealmQuery = mRealm.where(InitialData.class);
        mRealmResults = mRealmQuery.findAll();
    }

    private void setCumulativeNumberOfSmoking(View view) {
        setRealm();
        mInitialData = mRealmResults.get(0);
        mNumberOfSmokingOnDay = mInitialData.getSmokingNum();
        mTotalSmokingPeriod = mInitialData.getTotalSmokingPeriod();
        mTextTimeNonSmokingPeriod = view.findViewById(R.id.text_count_cumulative_number_of_smoking);
        String cumulativeNumberOfSmoking = mNumberOfSmokingOnDay * mTotalSmokingPeriod * 365 + getString(R.string.text_unit_number);
        mTextTimeNonSmokingPeriod.setText(cumulativeNumberOfSmoking);
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
