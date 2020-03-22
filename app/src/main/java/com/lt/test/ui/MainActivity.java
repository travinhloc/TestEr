package com.lt.test.ui;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.lt.test.App;
import com.lt.test.base.BaseActivity;
import com.lt.test.databinding.ActivityMainBinding;
import com.lt.test.models.City;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainContract.View {

    private ActivityMainBinding binding;

    @Inject
    MainContract.Presenter presenter;
    @Inject
    MainContract.Interactor interactor;
    private CitiesAdapter adapter;

    @Override
    public void afterInject() {
        App.getInstance().getComponent().inject(this);
    }

    @Override
    public void afterView() {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        presenter.onCreate(this, this, interactor);
    }

    @Override
    public void initUI(List<City> cities) {
        adapter = new CitiesAdapter(cities);
        binding.rvCities.setLayoutManager(new LinearLayoutManager(this));
        binding.rvCities.setHasFixedSize(true);
        binding.rvCities.setAdapter(adapter);
    }

    @Override
    public void notifyDataChanged(List<City> cities) {
        adapter.notifyDataSetChanged();
    }
}
