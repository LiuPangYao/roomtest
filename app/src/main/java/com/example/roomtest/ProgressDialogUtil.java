package com.example.roomtest;

import android.app.AlertDialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.roomtest.databinding.CustomProgressDialogViewBinding;

/**
 * 2021-10-10 view binding
 */
public class ProgressDialogUtil {

    private static AlertDialog mAlertDialog;

    public static void showProgressDialog(Context context) {

        //if (mAlertDialog == null) {
            mAlertDialog = new AlertDialog.Builder(context, R.style.CustomProgressDialog).create();
        //}

        CustomProgressDialogViewBinding binding = CustomProgressDialogViewBinding.inflate(LayoutInflater.from(context.getApplicationContext()));

        mAlertDialog.setView(binding.getRoot(), 0, 0, 0, 0);
        mAlertDialog.setCanceledOnTouchOutside(false);

        binding.textviewTip.setText(context.getString(R.string.PROGRESS_DIALOG));

        mAlertDialog.show();
    }

    public static void showProgressDialog(Context context, String tip) {
        if (TextUtils.isEmpty(tip)) {
            tip = context.getString(R.string.PROGRESS_DIALOG);
        }

        if (mAlertDialog == null) {
            mAlertDialog = new AlertDialog.Builder(context, R.style.CustomProgressDialog).create();
        }

        View loadView = LayoutInflater.from(context).inflate(R.layout.custom_progress_dialog_view, null);
        mAlertDialog.setView(loadView, 0, 0, 0, 0);
        mAlertDialog.setCanceledOnTouchOutside(false);

        TextView tvTip = loadView.findViewById(R.id.textviewTip);
        tvTip.setText(tip);

        mAlertDialog.show();
    }

    public static void dismiss() {
        if (mAlertDialog != null && mAlertDialog.isShowing()) {
            mAlertDialog.dismiss();
        }
    }
}
