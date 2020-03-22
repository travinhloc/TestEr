package com.lt.test.models;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Observable;

@Dao
public interface CityDao {

    @Query("SELECT * FROM cities")
    Observable<List<City>> getAllCities();
}
