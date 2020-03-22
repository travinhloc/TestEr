package com.lt.test;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;


import com.lt.test.models.AppDatabase;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import io.reactivex.disposables.CompositeDisposable;

@RunWith(AndroidJUnit4.class)
public class DatabaseTest {

    private static final int TOTAL_RECORD = 272128;

    @Rule
    public InstantTaskExecutorRule instantExecutorRule = new InstantTaskExecutorRule();
    private AppDatabase appDatabase;
    private CompositeDisposable disposable;

    @Before
    public void createDb() {
        appDatabase = AppDatabase.getDatabase(App.getInstance().getApplicationContext());
        disposable = new CompositeDisposable();
    }

    @After
    public void closeDb() {
        appDatabase.close();
    }

    @Test
    public void insertAndGetWord() throws Exception {
        appDatabase.cityDao()
                .getAllCities()
                .test()
                .assertValue(cities -> cities.size() == TOTAL_RECORD);
    }
}
