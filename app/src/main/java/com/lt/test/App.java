package com.lt.test;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

import com.lt.test.di.ApplicationComponent;
import com.lt.test.di.DaggerApplicationComponent;

public class App extends Application {

    private static  App instance = null;
    private ApplicationComponent component;
    public App() {
    }

    public static App getInstance() {
        if (instance == null) {
            instance = new App();
            instance.onCreate();
        }
        return instance;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initComponent();
    }

    private void initComponent(){
        component = DaggerApplicationComponent.builder().build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
