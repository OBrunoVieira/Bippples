package com.example.brunovieira.bippples.presentation.presenter.interfaces;

import com.example.brunovieira.bippples.model.entities.ShotsVO;
import com.example.brunovieira.bippples.model.event.ShotsResultEvent;
import com.example.brunovieira.bippples.presentation.view.activity.interfaces.HomeView;

import org.greenrobot.eventbus.Subscribe;

import java.util.List;

/**
 * Created by bruno.vieira on 28/03/2016.
 */
public interface HomePresenter {
    void attachView(HomeView homeView);

    void getShotsList();

    @Subscribe
    void onShotsResult(ShotsResultEvent shotsResultEvent);
}
