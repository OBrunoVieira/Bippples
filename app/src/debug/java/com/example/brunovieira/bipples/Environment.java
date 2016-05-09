package com.example.brunovieira.bipples;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by bruno.vieira on 03/05/2016.
 */
public class Environment {
    public static final String RANDOM_JOKE_URL = "http://api.icndb.com/jokes/random";
    public static final String SERVER_URL = "https://api.dribbble.com/v1/";
    public static final String ACCESS_TOKEN = "a021928e475b71c91b93eeaab188013bb81b8b7c49c042d63f6176a362793bd3";
    public static final HttpLoggingInterceptor.Level LOG_LEVEL = HttpLoggingInterceptor.Level.BODY;
}
