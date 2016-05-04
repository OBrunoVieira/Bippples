package com.example.brunovieira.bippples.presentation.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.brunovieira.bippples.R;
import com.example.brunovieira.bippples.model.entities.ShotsVO;
import com.example.brunovieira.bippples.presentation.presenter.HomePresenterImpl;
import com.example.brunovieira.bippples.presentation.presenter.interfaces.HomePresenter;
import com.example.brunovieira.bippples.presentation.view.activity.interfaces.HomeView;
import com.example.brunovieira.bippples.presentation.view.adapter.ShotsAdapter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.List;

@EActivity(R.layout.activity_home)
public class HomeActivity extends AppCompatActivity implements HomeView {
    @ViewById(R.id.activity_main_recyclerview)
    RecyclerView recyclerView;

    @ViewById(R.id.activity_default_toolbar)
    Toolbar toolbar;

    @Bean(HomePresenterImpl.class)
    HomePresenter homePresenter;

    @Bean
    ShotsAdapter shotsAdapter;

    @AfterViews
    public void afterViews() {
        setSupportActionBar(toolbar);
        homePresenter.attachView(this);
        homePresenter.getShotsList();
    }

    @Override
    public void showRecyclerView(ShotsAdapter shotsAdapter) {
        recyclerView.setAdapter(shotsAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
    }

    @Override
    public ShotsAdapter createShotAdapter(List<ShotsVO> listShots) {
        shotsAdapter.setItems(listShots);
        return shotsAdapter;
    }
}
