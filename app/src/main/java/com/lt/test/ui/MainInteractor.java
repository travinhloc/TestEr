package com.lt.test.ui;

import android.content.Context;

import com.lt.test.base.BaseInteractor;
import com.lt.test.base.OnStatusApiView;
import com.lt.test.models.CitiesRepository;
import com.lt.test.models.City;
import com.lt.test.utils.LogUtil;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class MainInteractor extends BaseInteractor implements MainContract.Interactor {

    public MainInteractor() {
        disposable = new CompositeDisposable();
    }

    @Override
    public void getAllCities(Context context, OnStatusApiView<List<City>> onStatusApiView) {
        onStatusApiView.inProgress();
        disposable.add(new CitiesRepository(context).getAllCities()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(cities -> {
                    onStatusApiView.resultSuccess(cities);
                    onStatusApiView.finishProgress();
                }, throwable -> {
                    onStatusApiView.finishProgress();
                    LogUtil.e(throwable.getMessage());
                })
        );

    }
}
