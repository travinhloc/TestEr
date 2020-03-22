package com.lt.test.base;

import android.content.Context;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseInteractor implements BaseActivityContract.Interactor {

    protected final String TAG = this.getClass().getSimpleName();

    protected Context context;
    protected CompositeDisposable disposable = new CompositeDisposable();
}
