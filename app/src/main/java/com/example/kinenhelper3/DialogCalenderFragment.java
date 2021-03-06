package com.example.kinenhelper3;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import java.util.Calendar;

public class DialogCalenderFragment extends DialogFragment {

    private String mTAGTime = "time";

    public Dialog onCreateDialog(Bundle savedInstanceState){

        final Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                String date = year + "年" + (month + 1) + "月" + dayOfMonth + "日";
                DialogTimeFragment dialogTimeFragment = new DialogTimeFragment(date);
                dialogTimeFragment.show(getFragmentManager(),mTAGTime);
            }
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH));

        return datePickerDialog;
    }
}
