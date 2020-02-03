package com.example.kinenhelper3;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.Timer;
import java.util.TimerTask;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class ProgressFragment extends Fragment {
    private Realm mRealm;
    private RealmQuery<InitialData> mRealmQuery;
    private RealmResults<InitialData> mRealmResults;
    private InitialData mInitialData;

    private int mNumberOfSmokingOnDay;
    private int mTotalSmokingPeriod;
    private TextView mTextTimeNonSmokingPeriod;
    int count = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_progress, container, false);
        setCumulativeNumberOfSmoking(view);

        final TextView textView = view.findViewById(R.id.text_cheering_message);

        final String[] string = {"aaa", "bbb"};
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(string[count]);
                    }
                });

                if (count == 0) {
                    count = 1;
                } else {
                    count = 0;
                }
            }
        };
        timer.schedule(timerTask, 0, 500);

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

//    private void changeCheeringMessage() {
//
//        Timer timer = new Timer();
//        timer.schedule(new TaskCheeringMessage(),0, 4000);
//
//    }

}
