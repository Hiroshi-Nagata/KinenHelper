package com.example.kinenhelper3;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

public class CustomDialogFragment extends DialogFragment {

    private CustomDialogInterface customDialogListener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        final String[] items = getResources().getStringArray(R.array.list_goal_setting);
        dialogBuilder.setTitle(R.string.text_dialog_title);
        dialogBuilder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String selectedValue = items[i];
                if (customDialogListener != null) {
                    customDialogListener.onSuccess(selectedValue);
                }
            }
        });
        return dialogBuilder.create();
    }

    public void setCustomDialogListener(CustomDialogInterface customDialogListener) {
        this.customDialogListener = customDialogListener;
    }
}
