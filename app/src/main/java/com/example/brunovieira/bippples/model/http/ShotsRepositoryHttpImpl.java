package com.example.brunovieira.bippples.model.http;

import com.example.brunovieira.bippples.common.bus.BusProviderImpl;
import com.example.brunovieira.bippples.common.bus.interfaces.BusProvider;
import com.example.brunovieira.bippples.common.custom.HandleCallback;
import com.example.brunovieira.bippples.model.entities.ShotsVO;
import com.example.brunovieira.bippples.model.event.Http4xxEvent;
import com.example.brunovieira.bippples.model.event.Http5xxEvent;
import com.example.brunovieira.bippples.model.event.NetworkErrorEvent;
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
    public void getShotsList(String accessToken) {
        webServiceManager.getWebServiceApiInstance().getShotsList(accessToken).enqueue(new HandleCallback<List<ShotsVO>>() {
            @Override
            protected void onSuccess(Call<List<ShotsVO>> call, Response<List<ShotsVO>> response) {
                busProvider.getRepositoryBus().post(response.body());
            }

            @Override
            protected void onClientError(Call<List<ShotsVO>> call, Response<List<ShotsVO>> response) {
                busProvider.getRepositoryBus().post(new Http4xxEvent());
            }

            @Override
            protected void onServerError(Call<List<ShotsVO>> call, Response<List<ShotsVO>> response) {
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
