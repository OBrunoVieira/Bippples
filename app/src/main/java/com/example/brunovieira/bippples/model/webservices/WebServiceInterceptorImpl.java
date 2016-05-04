package com.example.brunovieira.bippples.model.webservices;

import com.example.brunovieira.bippples.model.webservices.interfaces.WebServiceInterceptor;

import org.androidannotations.annotations.EBean;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by bruno.vieira on 03/05/2016.
 */
@EBean
public class WebServiceInterceptorImpl implements WebServiceInterceptor, Interceptor {

    @Override
    public OkHttpClient clientInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(this);
        httpClient.addInterceptor(interceptor);
        httpClient.connectTimeout(10, TimeUnit.SECONDS);
        httpClient.readTimeout(10, TimeUnit.SECONDS);
        return httpClient.build();
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        request = request.newBuilder()
//                .addHeader()
                .build();

        return chain.proceed(request);
    }
}
