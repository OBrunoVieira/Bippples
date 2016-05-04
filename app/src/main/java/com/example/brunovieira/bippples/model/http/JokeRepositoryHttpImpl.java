package com.example.brunovieira.bippples.model.http;

import com.example.brunovieira.bippples.common.bus.BusProviderImpl;
import com.example.brunovieira.bippples.common.bus.interfaces.BusProvider;
import com.example.brunovieira.bippples.common.custom.HandleCallback;
import com.example.brunovieira.bippples.model.entities.JokeVO;
import com.example.brunovieira.bippples.model.entities.ShotsVO;
import com.example.brunovieira.bippples.model.event.Http4xxEvent;
import com.example.brunovieira.bippples.model.event.Http5xxEvent;
import com.example.brunovieira.bippples.model.event.NetworkErrorEvent;
import com.example.brunovieira.bippples.model.event.UnexpectedErrorEvent;
import com.example.brunovieira.bippples.model.http.interfaces.JokeRepositoryHttp;
import com.example.brunovieira.bippples.model.webservices.WebServiceManagerImpl;
import com.example.brunovieira.bippples.model.webservices.interfaces.WebServiceManager;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by bruno.vieira on 04/05/2016.
 */
@EBean
public class JokeRepositoryHttpImpl implements JokeRepositoryHttp {

    @Bean(BusProviderImpl.class)
    BusProvider busProvider;

    @Bean(WebServiceManagerImpl.class)
    WebServiceManager webServiceManager;

    @Override
    public void getAJoke(String url) {
        webServiceManager.getWebServiceApiInstance().getAJoke(url).enqueue(new HandleCallback<JokeVO>() {
            @Override
            protected void onSuccess(Call<JokeVO> call, Response<JokeVO> response) {
                busProvider.getRepositoryBus().post(response.body());
            }

            @Override
            protected void onClientError(Call<JokeVO> call, Response<JokeVO> response) {
                busProvider.getRepositoryBus().post(new Http4xxEvent());
            }

            @Override
            protected void onServerError(Call<JokeVO> call, Response<JokeVO> response) {
                busProvider.getRepositoryBus().post(new Http5xxEvent());
            }

            @Override
            protected void networkError() {
                busProvider.getRepositoryBus().post(new NetworkErrorEvent());
            }

            @Override
            protected void unexpectedError() {
                busProvider.getRepositoryBus().post(new UnexpectedErrorEvent());
            }
        });
    }
}
