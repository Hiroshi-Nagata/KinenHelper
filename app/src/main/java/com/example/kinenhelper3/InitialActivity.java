package com.example.kinenhelper3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class InitialActivity extends AppCompatActivity {

    private String mTAGDate = "date";
    private final int MINIMUM_NUMBER_OF_SMOKING = 0;
    private final int MAXIMUM_NUMBER_OF_SMOKING = 100;
    private final int MINIMUM_NUMBER_OF_CIGARETTES = 10;
    private final int MAXIMUM_NUMBER_OF_CIGARETTES = 20;
    private final int MINIMUM_NUMBER_OF_TOTAL_SMOKING_PERIOD = 1;
    private final int MAXIMUM_NUMBER_OF_TOTAL_SMOKING_PERIOD = 100;
    private final float MINIMUM_NUMBER_OF_TAR = 0.5f;
    private final float MAXIMUM_NUMBER_OF_TAR = 30.0f;
    private final float MINIMUM_NUMBER_OF_NICOTINE = 0.1f;
    private final float MAXIMUM_NUMBER_OF_NICOTINE = 2.5f;

    private int mNumberOfSmoking = 20;
    private int mNumberOfCigarettes = 20;
    private int mNumberOfTotalSmokingPeriod = 10;
    private float mNumberOfTar = 10.0f;
    private float mNumberOfNicotine = 0.5f;
    private TextView mTextNumberOfSmoking;
    private TextView mTextNumberOfCigarettes;
    private TextView mTextNumberOfTotalSmokingPeriod;
    private TextView mTextNumberOfTar;
    private TextView mTextNumberOfNicotine;
    private Button mButtonMinusNumberOfSmoking;
    private Button mButtonPlusNumberOfSmoking;
    private Button mButtonMinusNumberOfCigarettes;
    private Button mButtonPlusNumberOfCigarettes;
    private Button mButtonMinusTotalSmokingPeriod;
    private Button mButtonPlusTotalSmokingPeriod;
    private Button mButtonMinusTar;
    private Button mButtonPlusTar;
    private Button mButtonMinusNicotine;
    private Button mButtonPlusNicotine;
    private Button mButtonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);

        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(config);
        Button dateText = findViewById(R.id.button_time_stop_smoking);
        Date currentTime = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy'年'MM'月'dd'日'　H'時'mm'分'");
        dateText.setText(simpleDateFormat.format(currentTime));

        dateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogCalenderFragment dialogCalenderFragment = new DialogCalenderFragment();
                dialogCalenderFragment.show(getSupportFragmentManager(), mTAGDate);
            }
        });

        //1日の喫煙本数
        mButtonMinusNumberOfSmoking = findViewById(R.id.button_minus_number_of_smoking_onDay);
        mButtonPlusNumberOfSmoking = findViewById(R.id.button_plus_number_of_smoking_onDay);
        mTextNumberOfSmoking = findViewById(R.id.text_number_of_smoking);
        mButtonMinusNumberOfSmoking.setOnClickListener(minusCountNumberOfSmokingClickListener);
        mButtonPlusNumberOfSmoking.setOnClickListener(plusCountNumberOfSmokingClickListener);

        //1箱に入っている本数
        mButtonMinusNumberOfCigarettes = findViewById(R.id.button_minus_number_of_cigarettes_in_box);
        mButtonPlusNumberOfCigarettes = findViewById(R.id.button_plus_number_of_cigarettes_in_box);
        mTextNumberOfCigarettes = findViewById(R.id.text_number_of_cigarettes);
        mButtonMinusNumberOfCigarettes.setOnClickListener(minusCountNumberOfCigarettesClickListener);
        mButtonPlusNumberOfCigarettes.setOnClickListener(plusCountNumberOfCigarettesClickListener);

        //通算喫煙期間
        mButtonMinusTotalSmokingPeriod = findViewById(R.id.button_minus_total_smoking_period);
        mButtonPlusTotalSmokingPeriod = findViewById(R.id.button_plus_total_smoking_period);
        mTextNumberOfTotalSmokingPeriod = findViewById(R.id.text_number_of_total_smoking_period);
        mButtonMinusTotalSmokingPeriod.setOnClickListener(minusCountNumberOfTotalSmokingPeriodClickListener);
        mButtonPlusTotalSmokingPeriod.setOnClickListener(plusCountNumberOfTotalSmokingPeriodClickListener);

        //タールの量
        mButtonMinusTar = findViewById(R.id.button_minus_tar);
        mButtonPlusTar = findViewById(R.id.button_plus_tar);
        mTextNumberOfTar = findViewById(R.id.text_number_of_tar);
        mButtonMinusTar.setOnClickListener(minusCountNumberOfTarClickListener);
        mButtonPlusTar.setOnClickListener(plusCountNumberOfTarClickListener);

        //ニコチンの量
        mButtonMinusNicotine = findViewById(R.id.button_minus_nicotine);
        mButtonPlusNicotine = findViewById(R.id.button_plus_nicotine);
        mTextNumberOfNicotine = findViewById(R.id.text_number_of_nicotine);
        mButtonMinusNicotine.setOnClickListener(minusCountNumberOfNicotineClickListener);
        mButtonPlusNicotine.setOnClickListener(plusCountNumberOfNicotineClickListener);

        //次に進む
        mButtonNext = findViewById(R.id.button_next_for_initial);
        mButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                setUpdateData();
                startActivity(intent);
            }
        });
    }

    public void setTextOnButton(String date) {
        Button buttonDateText = findViewById(R.id.button_time_stop_smoking);
        buttonDateText.setText(date);
    }

    private View.OnClickListener minusCountNumberOfSmokingClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (mNumberOfSmoking > MINIMUM_NUMBER_OF_SMOKING) {
                mNumberOfSmoking--;
            } else {
                mNumberOfSmoking = MINIMUM_NUMBER_OF_SMOKING;
            }
            mTextNumberOfSmoking.setText(String.valueOf(mNumberOfSmoking));
        }
    };

    private View.OnClickListener plusCountNumberOfSmokingClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (mNumberOfSmoking < MAXIMUM_NUMBER_OF_SMOKING) {
                mNumberOfSmoking++;
            } else {
                mNumberOfSmoking = MAXIMUM_NUMBER_OF_SMOKING;
            }
            mTextNumberOfSmoking.setText(String.valueOf(mNumberOfSmoking));
        }
    };

    private View.OnClickListener minusCountNumberOfCigarettesClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (mNumberOfCigarettes > MINIMUM_NUMBER_OF_CIGARETTES) {
                mNumberOfCigarettes--;
            } else {
                mNumberOfCigarettes = MINIMUM_NUMBER_OF_CIGARETTES;
            }
            mTextNumberOfCigarettes.setText(String.valueOf(mNumberOfCigarettes));
        }
    };

    private View.OnClickListener plusCountNumberOfCigarettesClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (mNumberOfCigarettes < MAXIMUM_NUMBER_OF_CIGARETTES) {
                mNumberOfCigarettes++;
            } else {
                mNumberOfCigarettes = MAXIMUM_NUMBER_OF_CIGARETTES;
            }
            mTextNumberOfCigarettes.setText(String.valueOf(mNumberOfCigarettes));
        }
    };

    private View.OnClickListener minusCountNumberOfTotalSmokingPeriodClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (mNumberOfTotalSmokingPeriod > MINIMUM_NUMBER_OF_TOTAL_SMOKING_PERIOD) {
                mNumberOfTotalSmokingPeriod--;
            } else {
                mNumberOfTotalSmokingPeriod = MINIMUM_NUMBER_OF_TOTAL_SMOKING_PERIOD;
            }
            mTextNumberOfTotalSmokingPeriod.setText(String.valueOf(mNumberOfTotalSmokingPeriod));
        }
    };

    private View.OnClickListener plusCountNumberOfTotalSmokingPeriodClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (mNumberOfTotalSmokingPeriod < MAXIMUM_NUMBER_OF_TOTAL_SMOKING_PERIOD) {
                mNumberOfTotalSmokingPeriod++;
            } else {
                mNumberOfTotalSmokingPeriod = MAXIMUM_NUMBER_OF_TOTAL_SMOKING_PERIOD;
            }
            mTextNumberOfTotalSmokingPeriod.setText(String.valueOf(mNumberOfTotalSmokingPeriod));
        }
    };

    private View.OnClickListener minusCountNumberOfTarClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (mNumberOfTar > 1) {
                mNumberOfTar--;
            } else {
                mNumberOfTar = MINIMUM_NUMBER_OF_TAR;
            }
            String tarWithUnit = mNumberOfTar + getString(R.string.text_unit_mg);
            mTextNumberOfTar.setText(tarWithUnit);
        }
    };

    private View.OnClickListener plusCountNumberOfTarClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (mNumberOfTar == MINIMUM_NUMBER_OF_TAR) {
                mNumberOfTar += 0.5;
            } else if (mNumberOfTar < MAXIMUM_NUMBER_OF_TAR) {
                mNumberOfTar++;
            } else {
                mNumberOfTar = MAXIMUM_NUMBER_OF_TAR;
            }
            String tarWithUnit = mNumberOfTar + getString(R.string.text_unit_mg);
            mTextNumberOfTar.setText(tarWithUnit);
        }
    };

    private View.OnClickListener minusCountNumberOfNicotineClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (mNumberOfNicotine > MINIMUM_NUMBER_OF_NICOTINE + 0.01) {
                mNumberOfNicotine -= 0.1;
            } else {
                mNumberOfNicotine = MINIMUM_NUMBER_OF_NICOTINE;
            }
            String tarWithUnit = String.format("%.1f", mNumberOfNicotine) + getString(R.string.text_unit_mg);
            mTextNumberOfNicotine.setText(tarWithUnit);
        }
    };

    private View.OnClickListener plusCountNumberOfNicotineClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (mNumberOfNicotine < MAXIMUM_NUMBER_OF_NICOTINE - 0.01) {
                mNumberOfNicotine += 0.1;
            } else {
                mNumberOfNicotine = MAXIMUM_NUMBER_OF_NICOTINE;
            }
            String tarWithUnit = String.format("%.1f", mNumberOfNicotine) + getString(R.string.text_unit_mg);
            mTextNumberOfNicotine.setText(tarWithUnit);
        }
    };

    private void setUpdateData() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        InitialData initialData = realm.createObject(InitialData.class);

        initialData.setSmokingNum(mNumberOfSmoking);
        initialData.setNumberInBox(mNumberOfCigarettes);
        initialData.setTotalSmokingPeriod(mNumberOfTotalSmokingPeriod);
        initialData.setTar(mNumberOfTar);
        initialData.setNicotine(mNumberOfNicotine);

        realm.commitTransaction();
    }
}
