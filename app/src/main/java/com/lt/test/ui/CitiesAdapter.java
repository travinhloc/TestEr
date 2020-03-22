package com.lt.test.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.lt.test.BR;
import com.lt.test.R;
import com.lt.test.base.BaseViewHolder;
import com.lt.test.models.City;

import java.util.List;

public class CitiesAdapter extends RecyclerView.Adapter<BaseViewHolder>  {

    private List<City> cities;

    CitiesAdapter(List<City> cities) {
        this.cities = cities;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_cities, parent, false);
        return new BaseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, final int position) {
        holder.binding.setVariable(BR.city, cities.get(position));
    }

    @Override
    public int getItemCount() {
        return cities.size();
    }

    @BindingAdapter({"bind:count"})
    public static void setCount(TextView textView, int count) {
        textView.setText(String.valueOf(count));
    }
}
