package com.example.kinenhelper3;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
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
    private int mIndex;
//    private PieChart mPieChart;

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
                        mIndex = new Random().nextInt(mArrayCheeringData.length);
                        textCheeringMessage.setText(mArrayCheeringData[mIndex]);
                    }
                });
            }
        };
        timer.schedule(timerTask, 0, 4000);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        createPieChart();
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

    private void createPieChart() {
        PieChart mPieChart = getView().findViewById(R.id.chart_progress);

        mPieChart.setDrawHoleEnabled(true); // 真ん中に穴を空けるかどうか
        mPieChart.setHoleRadius(50f);       // 真ん中の穴の大きさ(%指定)
        mPieChart.setHoleColorTransparent(true);
        mPieChart.setTransparentCircleRadius(55f);
        mPieChart.setRotationAngle(270);          // 開始位置の調整
        mPieChart.setRotationEnabled(true);       // 回転可能かどうか
        mPieChart.getLegend().setEnabled(true);   //
        mPieChart.setDescription("PieChart 説明");
        mPieChart.setData(createPieChartData());

        // 更新
        mPieChart.invalidate();
        // アニメーション
        mPieChart.animateXY(2000, 2000);
    }

    private PieData createPieChartData() {
        ArrayList<Entry> yVals = new ArrayList<>();
        ArrayList<String> xVals = new ArrayList<>();
        ArrayList<Integer> colors = new ArrayList<>();

        xVals.add("A");
        xVals.add("B");
        xVals.add("C");

        yVals.add(new Entry(20, 0));
        yVals.add(new Entry(30, 1));
        yVals.add(new Entry(50, 2));

        PieDataSet dataSet = new PieDataSet(yVals, "Data");
        dataSet.setSliceSpace(5f);
        dataSet.setSelectionShift(1f);

        // 色の設定
        colors.add(ColorTemplate.COLORFUL_COLORS[0]);
        colors.add(ColorTemplate.COLORFUL_COLORS[1]);
        colors.add(ColorTemplate.COLORFUL_COLORS[2]);
        dataSet.setColors(colors);
        dataSet.setDrawValues(true);

        PieData data = new PieData(xVals, dataSet);
        data.setValueFormatter(new PercentFormatter());

        // テキストの設定
        data.setValueTextSize(12f);
        data.setValueTextColor(Color.WHITE);
        return data;
    }
}
