package com.lt.test.base;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import com.lt.test.R;
import com.lt.test.utils.DialogUtils;

public abstract class BaseActivity extends AppCompatActivity implements BaseActivityContract.View {

    protected final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.afterInject();
        this.afterView();
    }

    @Override
    public void showLoadingDialog() {
        showLoadingDialog(R.string.loading);
    }

    @Override
    public void showLoadingDialog(@StringRes int message) {
        DialogUtils.getInstance().showLoadingDialog(this, message);
    }

    @Override
    public void dismissLoadingDialog() {
        DialogUtils.getInstance().dismissLoadingDialog();
    }

    @Override
    public void toast(int id) {
        toast(getString(id));
    }

    @Override
    public void toast(@NonNull String message) {
        if (!TextUtils.isEmpty(message)) {
            Toast toast = Toast.makeText(this, message, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
    }
}
