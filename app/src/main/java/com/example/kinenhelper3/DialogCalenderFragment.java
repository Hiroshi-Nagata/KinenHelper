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

    private int year;
    private int month;
    private int dayOfMonth;
    private String date;

    public Dialog onCreateDialog(Bundle savedInstanceState){

        final Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                date = year + "年" + (month + 1) + "月" + dayOfMonth + "日";
                DialogTimeFragment dialogTimeFragment = new DialogTimeFragment();
                dialogTimeFragment.show(getFragmentManager(),"tagTime");
                setDate(date);

//                InitialActivity initialActivity = (InitialActivity) getActivity();
//                initialActivity.setTextOnButton(date);
            }
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH));

        return datePickerDialog;
    }

    public String getDate() {
        return date;
    }

    private void setDate(String date) {
        this.date = date;
    }

}
