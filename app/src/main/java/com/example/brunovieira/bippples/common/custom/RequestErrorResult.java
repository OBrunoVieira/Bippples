package com.example.brunovieira.bippples.common.custom;

import com.example.brunovieira.bippples.model.event.Http4xxEvent;
import com.example.brunovieira.bippples.model.event.Http5xxEvent;
import com.example.brunovieira.bippples.model.event.NetworkErrorEvent;
import com.example.brunovieira.bippples.model.event.UnexpectedErrorEvent;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by bruno.vieira on 03/05/2016.
 */
public interface RequestErrorResult {
    @Subscribe
    void onClientError(Http4xxEvent http4xxEvent);

    @Subscribe
    void onServerError(Http5xxEvent http5xxEvent);

    @Subscribe
    void networkError(NetworkErrorEvent networkErrorEvent);

    @Subscribe
    void unexpectedError(UnexpectedErrorEvent unexpectedErrorEvent);
}