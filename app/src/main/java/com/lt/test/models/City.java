package com.lt.test.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.room.Entity;

import java.util.Objects;

@Entity(tableName = "cities", primaryKeys = {"id"})
public class City extends BaseObservable implements Parcelable {

    @NonNull
    private String id;
    private String country;
    private  String city;
    private int population;

    public City() { }

    public City(@NonNull String id, String country, String city, int population) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.population = population;
    }

    protected City(Parcel in) {
        id = Objects.requireNonNull(in.readString());
        country = in.readString();
        city = in.readString();
        population = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(country);
        dest.writeString(city);
        dest.writeInt(population);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<City> CREATOR = new Creator<City>() {
        @Override
        public City createFromParcel(Parcel in) {
            return new City(in);
        }

        @Override
        public City[] newArray(int size) {
            return new City[size];
        }
    };


    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
