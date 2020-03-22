package com.lt.test.ui;

import android.content.Context;

import androidx.annotation.NonNull;

import com.lt.test.base.BaseActivityContract;
import com.lt.test.base.OnStatusApiView;
import com.lt.test.models.City;

import java.util.List;

public interface MainContract {

    interface View extends BaseActivityContract.View {

        void initUI(List<City> cities);

        void notifyDataChanged(List<City> cities);
    }

    interface Presenter extends BaseActivityContract.Presenter {

        void onCreate( @NonNull Context context, @NonNull View view, Interactor interactor);
    }

    interface Interactor extends BaseActivityContract.Interactor {

        void getAllCities(Context context, OnStatusApiView<List<City>> listOnStatusApiView);
    }
}
