package com.example.kinenhelper3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.Random;
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
    private TextView textCheeringMessage;
    private String[] mArrayCheeringData;
    private int index = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_progress, container, false);
        setCumulativeNumberOfSmoking(view);

        textCheeringMessage = view.findViewById(R.id.text_cheering_message);
        mArrayCheeringData = getResources().getStringArray(R.array.text_cheering_messages);
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        index = new Random().nextInt(mArrayCheeringData.length);
                        textCheeringMessage.setText(mArrayCheeringData[index]);
                    }
                });
            }
        };
        timer.schedule(timerTask, 0, 4000);

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
}
