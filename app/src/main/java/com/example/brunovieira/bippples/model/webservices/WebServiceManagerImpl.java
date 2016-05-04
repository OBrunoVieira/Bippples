package com.example.brunovieira.bippples.model.webservices;

import com.example.brunovieira.bipples.Environment;
import com.example.brunovieira.bippples.model.webservices.interfaces.WebServiceApi;
import com.example.brunovieira.bippples.model.webservices.interfaces.WebServiceInterceptor;
import com.example.brunovieira.bippples.model.webservices.interfaces.WebServiceManager;
import com.github.aurae.retrofit2.LoganSquareConverterFactory;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import retrofit2.Retrofit;

/**
 * Created by bruno.vieira on 03/05/2016.
 */
@EBean(scope = EBean.Scope.Singleton)
public class WebServiceManagerImpl implements WebServiceManager {

    @Bean(WebServiceInterceptorImpl.class)
    WebServiceInterceptor webServiceInterceptor;
    private WebServiceApi webServiceApi;

    @AfterInject
    public void afterInject() {
        setupApi();
    }

    @Override
    public WebServiceApi getWebServiceApiInstance() {
        return webServiceApi;
    }

    private void setupApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Environment.SERVER_URL)
                .addConverterFactory(LoganSquareConverterFactory.create())
                .client(webServiceInterceptor.clientInterceptor())
                .build();

        webServiceApi = retrofit.create(WebServiceApi.class);
    }
}
