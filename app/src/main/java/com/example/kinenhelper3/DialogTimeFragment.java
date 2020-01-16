package com.example.kinenhelper3;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.TimePicker;

import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class DialogTimeFragment extends DialogFragment {
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar calendar = Calendar.getInstance();
        TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(),
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hour, int minutes) {
                        String time = hour + "時" + minutes + "分";
                        DialogCalenderFragment dialogCalenderFragment = new DialogCalenderFragment();

                        String dateTime = dialogCalenderFragment.getDate() + " " + time;

                        InitialActivity initialActivity = (InitialActivity) getActivity();
                        initialActivity.setTextOnButton(dateTime);
                    }
                },
                calendar.get(Calendar.HOUR),
                calendar.get(Calendar.MINUTE),
                true);

        return timePickerDialog;
    }
}
