package com.example.kinenhelper3;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

public class CustomDialogFragment extends DialogFragment {
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        final String[] items = getResources().getStringArray(R.array.list_goal_setting);
        dialogBuilder.setTitle(R.string.text_dialog_title);
        dialogBuilder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String selectedValue = items[i];
                ProgressFragment progressFragment = new ProgressFragment();
                progressFragment.setTextSettingGoal(selectedValue);
            }
        });
        return dialogBuilder.create();
    }
}
