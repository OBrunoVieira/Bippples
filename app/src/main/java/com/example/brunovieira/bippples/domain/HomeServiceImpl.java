package com.example.brunovieira.bippples.domain;

import com.example.brunovieira.bipples.Environment;
import com.example.brunovieira.bippples.common.bus.BusProviderImpl;
import com.example.brunovieira.bippples.common.bus.interfaces.BusProvider;
import com.example.brunovieira.bippples.common.custom.RequestErrorResult;
import com.example.brunovieira.bippples.domain.interfaces.HomeService;
import com.example.brunovieira.bippples.model.entities.JokeVO;
import com.example.brunovieira.bippples.model.event.Http4xxEvent;
import com.example.brunovieira.bippples.model.event.Http5xxEvent;
import com.example.brunovieira.bippples.model.event.NetworkErrorEvent;
import com.example.brunovieira.bippples.model.event.ShotsResultEvent;
import com.example.brunovieira.bippples.model.event.UnexpectedErrorEvent;
import com.example.brunovieira.bippples.model.http.JokeRepositoryHttpImpl;
import com.example.brunovieira.bippples.model.http.ShotsRepositoryHttpImpl;
import com.example.brunovieira.bippples.model.http.interfaces.JokeRepositoryHttp;
import com.example.brunovieira.bippples.model.http.interfaces.ShotsRepositoryHttp;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by bruno.vieira on 28/03/2016.
 */
@EBean
public class HomeServiceImpl implements HomeService, RequestErrorResult {

    @Bean(ShotsRepositoryHttpImpl.class)
    ShotsRepositoryHttp shotsRepositoryHttp;

    @Bean(JokeRepositoryHttpImpl.class)
    JokeRepositoryHttp jokeRepositoryHttp;

    @Bean(BusProviderImpl.class)
    BusProvider busProvider;

    @Override
    @Background
    public void getShotsList() {
        busProvider.getRepositoryBus().register(this);
        jokeRepositoryHttp.getAJoke(Environment.RANDOM_JOKE_URL);
    }

    @Override
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onJokeResult(JokeVO jokeVO){
        shotsRepositoryHttp.getShotsList(Environment.ACCESS_TOKEN, jokeVO);
    }

    @Override
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onShotsResult(ShotsResultEvent shotsResultEvent) {
        busProvider.getRepositoryBus().unregister(this);
        busProvider.getServiceBus().post(shotsResultEvent);
    }

    @Override
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onClientError(Http4xxEvent http4xxEvent) {
        busProvider.getRepositoryBus().unregister(this);
    }

    @Override
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onServerError(Http5xxEvent http5xxEvent) {
        busProvider.getRepositoryBus().unregister(this);
    }

    @Override
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void networkError(NetworkErrorEvent networkErrorEvent) {
        busProvider.getRepositoryBus().unregister(this);
    }

    @Override
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void unexpectedError(UnexpectedErrorEvent unexpectedErrorEvent) {
        busProvider.getRepositoryBus().unregister(this);
    }
}
