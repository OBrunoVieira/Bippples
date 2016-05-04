package com.example.brunovieira.bippples.presentation.view.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;

import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;
import com.example.brunovieira.bippples.R;
import com.example.brunovieira.bippples.common.custom.CustomSwipeRefresh;
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
public class HomeActivity extends AppCompatActivity implements HomeView, SwipeRefreshLayout.OnRefreshListener {
    @ViewById(R.id.activity_home_recyclerview)
    RecyclerView recyclerView;

    @ViewById(R.id.activity_default_toolbar)
    Toolbar toolbar;

    @ViewById(R.id.activity_home_swipe_refresh)
    CustomSwipeRefresh swipeRefresh;

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
    public void hideSwipeRefresh() {
        swipeRefresh.setRefreshing(false);
    }

    @Override
    public void setupSwipeRefreshListener() {
        swipeRefresh.setOnRefreshListener(this);
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

    @Override
    public void showJokeDialog(String jokeDescription) {
        new MaterialDialog.Builder(this)
                .title(R.string.just_a_joke)
                .content(Html.fromHtml(jokeDescription))
                .theme(Theme.LIGHT)
                .show();
    }

    @Override
    public void onRefresh() {
        homePresenter.getShotsList();
    }
}
