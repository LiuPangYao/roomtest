package com.example.roomtest.diaog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.example.roomtest.R;

/**
 * 2019-12-19
 */
public class deleteDialogFragment extends DialogFragment {

    static deleteDialogFragment dialog;
    deleteDialogListener listener;
    static int position;
    static String title;

    public interface deleteDialogListener {
        void onDialogOKClick(DialogFragment dialog, int position);

        void onDialogCancelClick(DialogFragment dialog);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            listener = (deleteDialogListener) context;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(context.toString() + " must implement NoticeDialogListener");
        }
    }

    public static deleteDialogFragment instance(String mTitle, int mPosition) {
        dialog = new deleteDialogFragment();
        title = mTitle;
        position = mPosition;
        return dialog;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        return new AlertDialog.Builder(getActivity())
                .setTitle(title)
                .setMessage(getString(R.string.DELETE_CHECK))
                .setPositiveButton(R.string.OK,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                listener.onDialogOKClick(deleteDialogFragment.this, position);
                            }
                        }
                )
                .setNegativeButton(R.string.CANCEL,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                listener.onDialogCancelClick(deleteDialogFragment.this);
                            }
                        }
                )
                .create();
    }
}
