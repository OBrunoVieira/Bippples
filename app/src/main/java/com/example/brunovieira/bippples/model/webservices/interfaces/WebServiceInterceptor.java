package com.example.brunovieira.bippples.model.webservices.interfaces;

import okhttp3.OkHttpClient;

/**
 * Created by bruno.vieira on 03/05/2016.
 */
public interface WebServiceInterceptor {
    OkHttpClient clientInterceptor();
}
