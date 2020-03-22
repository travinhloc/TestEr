package com.lt.test.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import androidx.annotation.NonNull;

public class Utils {

    public static int getHeight(@NonNull Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int getWidth(@NonNull Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }
}
