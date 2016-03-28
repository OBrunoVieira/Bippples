package com.example.brunovieira.bippples.presentation.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.example.brunovieira.bippples.R;
import com.example.brunovieira.bippples.presentation.presenter.HomePresenterImpl;
import com.example.brunovieira.bippples.presentation.presenter.interfaces.HomePresenter;
import com.example.brunovieira.bippples.presentation.view.activity.interfaces.HomeView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_home)
public class HomeActivity extends AppCompatActivity implements HomeView {
    @ViewById(R.id.activity_main_recyclerview)
    RecyclerView recyclerView;

    @Bean(HomePresenterImpl.class)
    HomePresenter homePresenter;

    @AfterViews
    public void afterViews() {
        homePresenter.attachView(this);
    }

    @Override
    public void showRecyclerView() {

    }
}
