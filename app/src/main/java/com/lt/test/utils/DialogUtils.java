package com.lt.test.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

public class DialogUtils {

    private static DialogUtils instance;

    private ProgressDialog mProgressDialog;

    private DialogUtils() {
    }

    public static DialogUtils getInstance() {
        if (instance == null) {
            instance = new DialogUtils();
        }
        return instance;
    }

    public void showLoadingDialog(@NonNull Context context, int message) {
        mProgressDialog = new ProgressDialog(context);
        mProgressDialog.setMessage(context.getString(message));
        mProgressDialog.setCanceledOnTouchOutside(false);
        mProgressDialog.show();
    }

    public void showLoadingDialog(Context context, String message) {
        mProgressDialog = new ProgressDialog(context);
        mProgressDialog.setMessage(message);
        mProgressDialog.setCanceledOnTouchOutside(false);
        mProgressDialog.show();
    }

    public void dismissLoadingDialog() {
        if (mProgressDialog != null) {
            try {
                mProgressDialog.dismiss();
            } catch (IllegalArgumentException ex) {
                Log.e(getClass().getSimpleName(), "Activity is already finished, no need dismissing dialog");
            }
        }
    }
}
