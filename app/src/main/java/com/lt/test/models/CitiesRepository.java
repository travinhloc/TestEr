package com.lt.test.models;

import android.content.Context;

import java.util.List;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;

public class CitiesRepository {

    private CityDao cityDao;

    public CitiesRepository(Context context) {
        AppDatabase db = AppDatabase.getDatabase(context);
        cityDao = db.cityDao();
    }

    public Flowable<List<City>> getAllCities() {
        return Flowable.create(emitter ->
                        cityDao.getAllCities().subscribe(emitter::onNext, emitter::onError)
                , BackpressureStrategy.BUFFER);
    }
}
