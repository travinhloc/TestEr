package com.lt.test.ui;

import android.content.Context;

import androidx.annotation.NonNull;

import com.lt.test.base.BaseActivityPresenter;
import com.lt.test.base.OnStatusApiView;
import com.lt.test.models.City;

import java.util.ArrayList;
import java.util.List;

public class MainPresenter extends BaseActivityPresenter implements MainContract.Presenter {

    private MainContract.View view;
    private MainContract.Interactor interactor;
    private List<City> cities;

    @Override
    public void onCreate(@NonNull Context context, @NonNull MainContract.View view, MainContract.Interactor interactor) {
        this.context = context;
        this.interactor = interactor;
        this.view = view;
        cities = new ArrayList<>();
        view.initUI(cities);
        onLoadData();
    }

    private void onLoadData() {
        interactor.getAllCities(context, new OnStatusApiView<List<City>>() {
            @Override
            public void resultSuccess(List<City> result) {
                cities.clear();
                cities.addAll(result);
            }

            @Override
            public void inProgress() {
                view.showLoadingDialog();
            }

            @Override
            public void finishProgress() {
                view.dismissLoadingDialog();
                view.notifyDataChanged(cities);
            }
        });
    }

}
