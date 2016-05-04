package com.example.brunovieira.bippples.common.custom;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by bruno.vieira on 03/05/2016.
 */
public abstract class HandleCallback<T> implements Callback<T> {

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.code() >= 200 && response.code() < 400) {
            onSuccess(call, response);
            return;
        }

        if (response.code() >= 400 && response.code() < 500) {
            onClientError(call, response);
            return;
        }

        if (response.code() >= 500 && response.code() < 600) {
            onServerError(call, response);
            return;
        }

        unexpectedError();

    }

    @Override
    public void onFailure(Call<T> call, Throwable throwable) {
        if (throwable instanceof IOException) {
            networkError();
            return;
        }
        unexpectedError();
    }

//    private void handleErrorStatusCode(int statusCode, Response<T> response) {
//        switch (statusCode) {
//            case StatusCode.ERROR_400:
//                badRequestError(response);
//                break;
//
//            case StatusCode.ERROR_401:
//                unauthorizedError(response);
//                break;
//
//            case StatusCode.ERROR_403:
//                forbiddenError(response);
//                break;
//
//            case StatusCode.ERROR_404:
//                notFoundError(response);
//                break;
//
//            default:
//                unexpectedError();
//                break;
//        }
//    }

    protected abstract void onSuccess(Call<T> call, Response<T> response);

    protected abstract void onClientError(Call<T> call, Response<T> response);

    protected abstract void onServerError(Call<T> call, Response<T> response);

//    protected abstract void badRequestError(Response<T> response);

//    protected abstract void unauthorizedError(Response<T> response);

//    protected abstract void forbiddenError(Response<T> response);

//    protected abstract void notFoundError(Response<T> response);

    protected abstract void networkError();

    protected abstract void unexpectedError();
}

