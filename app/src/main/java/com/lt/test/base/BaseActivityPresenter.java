package com.lt.test.base;

import android.content.Context;

public abstract class BaseActivityPresenter implements BaseActivityContract.Presenter {

    protected final String TAG = this.getClass().getSimpleName();

    protected Context context;
}
