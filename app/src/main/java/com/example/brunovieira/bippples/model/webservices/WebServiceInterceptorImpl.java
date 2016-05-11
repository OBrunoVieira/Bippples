package com.example.brunovieira.bippples.model.webservices;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.net.ConnectivityManagerCompat;
import android.util.Log;

import com.example.brunovieira.bipples.Environment;
import com.example.brunovieira.bippples.Bippples_;
import com.example.brunovieira.bippples.common.custom.Connectivity;
import com.example.brunovieira.bippples.model.webservices.interfaces.WebServiceInterceptor;

import org.androidannotations.annotations.EBean;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by bruno.vieira on 03/05/2016.
 */
@EBean
public class WebServiceInterceptorImpl implements WebServiceInterceptor, Interceptor {

    static final long cacheSize = 10 * 1024 * 1024;

    @Override
    public OkHttpClient clientInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(Environment.LOG_LEVEL);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.cache(new Cache(new File(Bippples_.getInstance().getCacheDir(), "http"), cacheSize));
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
                .addHeader("Cache-Control",
                        Connectivity.networkIsAvailable(Bippples_.getInstance()) ?
                                "public, max-age=60" :
                                String.format("public, only-if-cached, max-stale=%s", 60 * 60 * 24 * 7))
                .build();

        return chain.proceed(request);
    }

}
