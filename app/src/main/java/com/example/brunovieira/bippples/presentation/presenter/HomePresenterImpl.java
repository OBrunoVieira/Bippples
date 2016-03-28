package com.example.brunovieira.bippples.presentation.presenter;

import com.example.brunovieira.bippples.domain.HomeServiceImpl;
import com.example.brunovieira.bippples.domain.interfaces.HomeService;
import com.example.brunovieira.bippples.presentation.presenter.interfaces.HomePresenter;
import com.example.brunovieira.bippples.presentation.view.activity.interfaces.HomeView;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

/**
 * Created by bruno.vieira on 28/03/2016.
 */
@EBean
public class HomePresenterImpl implements HomePresenter {

    @Bean(HomeServiceImpl.class)
    HomeService homeService;

    HomeView homeView;

    @Override
    public void attachView(HomeView homeView){
        this.homeView = homeView;
    }
}
