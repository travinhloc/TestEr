package com.lt.test.models;

import android.content.Context;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.huma.room_for_asset.RoomAsset;

@Database(entities = {City.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public static final String DB_NAME = "utopia_cities.db";
    private static AppDatabase INSTANCE;

    public abstract CityDao cityDao();

    public static AppDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    RoomAsset.databaseBuilder(context, AppDatabase.class, DB_NAME)
                            .fallbackToDestructiveMigration()
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        if (INSTANCE != null) {
            INSTANCE = null;
        }
    }
}
