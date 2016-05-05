package com.example.brunovieira.bippples.model.http;

import com.example.brunovieira.bippples.Bippples_;
import com.example.brunovieira.bippples.R;
import com.example.brunovieira.bippples.common.bus.BusProviderImpl;
import com.example.brunovieira.bippples.common.bus.interfaces.BusProvider;
import com.example.brunovieira.bippples.common.custom.HandleCallback;
import com.example.brunovieira.bippples.model.entities.JokeVO;
import com.example.brunovieira.bippples.model.entities.ShotsVO;
import com.example.brunovieira.bippples.model.event.Http4xxEvent;
import com.example.brunovieira.bippples.model.event.Http5xxEvent;
import com.example.brunovieira.bippples.model.event.NetworkErrorEvent;
import com.example.brunovieira.bippples.model.event.ShotsResultEvent;
import com.example.brunovieira.bippples.model.event.UnexpectedErrorEvent;
import com.example.brunovieira.bippples.model.http.interfaces.ShotsRepositoryHttp;
import com.example.brunovieira.bippples.model.webservices.WebServiceManagerImpl;
import com.example.brunovieira.bippples.model.webservices.interfaces.WebServiceManager;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by bruno.vieira on 03/05/2016.
 */
@EBean
public class ShotsRepositoryHttpImpl implements ShotsRepositoryHttp {

    @Bean(WebServiceManagerImpl.class)
    WebServiceManager webServiceManager;

    @Bean(BusProviderImpl.class)
    BusProvider busProvider;

    @Override
    public void getShotsList(String accessToken, final JokeVO jokeVO) {
        webServiceManager.getWebServiceApiInstance().getShotsList(accessToken).enqueue(new HandleCallback<List<ShotsVO>>() {
            @Override
            protected void onSuccess(Call<List<ShotsVO>> call, Response<List<ShotsVO>> response) {
                busProvider.getRepositoryBus().post(new ShotsResultEvent(jokeVO, response.body()));
            }

            @Override
            protected void onClientError(Call<List<ShotsVO>> call, Response<List<ShotsVO>> response) {
                busProvider.getRepositoryBus().post(new Http4xxEvent(String.valueOf(response.code())));
            }

            @Override
            protected void onServerError(Call<List<ShotsVO>> call, Response<List<ShotsVO>> response) {
                busProvider.getRepositoryBus().post(new Http5xxEvent(String.valueOf(response.code())));
            }

            @Override
            protected void networkError() {
                busProvider.getRepositoryBus().post(new NetworkErrorEvent(Bippples_.getInstance().getString(R.string.network_error_description)));
            }

            @Override
            protected void unexpectedError() {
                busProvider.getRepositoryBus().post(new UnexpectedErrorEvent(Bippples_.getInstance().getString(R.string.unexpected_error_description)));
            }
        });
    }
}
