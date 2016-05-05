package com.example.brunovieira.bippples.presentation.presenter;

import com.example.brunovieira.bippples.common.bus.BusProviderImpl;
import com.example.brunovieira.bippples.common.custom.RequestErrorResult;
import com.example.brunovieira.bippples.domain.HomeServiceImpl;
import com.example.brunovieira.bippples.domain.interfaces.HomeService;
import com.example.brunovieira.bippples.model.entities.ShotsVO;
import com.example.brunovieira.bippples.model.event.Http4xxEvent;
import com.example.brunovieira.bippples.model.event.Http5xxEvent;
import com.example.brunovieira.bippples.model.event.NetworkErrorEvent;
import com.example.brunovieira.bippples.model.event.ShotsResultEvent;
import com.example.brunovieira.bippples.model.event.UnexpectedErrorEvent;
import com.example.brunovieira.bippples.presentation.presenter.interfaces.HomePresenter;
import com.example.brunovieira.bippples.presentation.view.activity.interfaces.HomeView;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

/**
 * Created by bruno.vieira on 28/03/2016.
 */
@EBean
public class HomePresenterImpl implements HomePresenter, RequestErrorResult {

    @Bean(HomeServiceImpl.class)
    HomeService homeService;

    @Bean(BusProviderImpl.class)
    BusProviderImpl busProvider;

    HomeView homeView;

    @Override
    public void attachView(HomeView homeView) {
        this.homeView = homeView;
        this.homeView.setupSwipeRefreshListener();
    }

    @Override
    public void getShotsList() {
        busProvider.getServiceBus().register(this);
        homeService.getShotsList();
    }

    @Override
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onShotsResult(ShotsResultEvent shotsResultEvent) {
        busProvider.getServiceBus().unregister(this);
        homeView.hideSwipeRefresh();
        homeView.showJokeDialog(shotsResultEvent.getJokeVO().getJokeValueVO().getJokeDescription());
        homeView.showRecyclerView(homeView.createShotAdapter(shotsResultEvent.getShotsList()));
    }

    @Override
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onClientError(Http4xxEvent http4xxEvent) {
        busProvider.getServiceBus().unregister(this);
        homeView.hideSwipeRefresh();
        homeView.showSnackBarError(http4xxEvent.getErrorDescription());
    }

    @Override
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onServerError(Http5xxEvent http5xxEvent) {
        busProvider.getServiceBus().unregister(this);
        homeView.hideSwipeRefresh();
        homeView.showSnackBarError(http5xxEvent.getErrorDescription());
    }

    @Override
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void networkError(NetworkErrorEvent networkErrorEvent) {
        busProvider.getServiceBus().unregister(this);
        homeView.hideSwipeRefresh();
        homeView.showSnackBarError(networkErrorEvent.getErrorDescription());
    }

    @Override
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void unexpectedError(UnexpectedErrorEvent unexpectedErrorEvent) {
        busProvider.getServiceBus().unregister(this);
        homeView.hideSwipeRefresh();
        homeView.showSnackBarError(unexpectedErrorEvent.getErrorDescription());
    }
}
