package com.example.brunovieira.bippples.model.http.interfaces;

import com.example.brunovieira.bippples.model.entities.JokeVO;

/**
 * Created by bruno.vieira on 03/05/2016.
 */
public interface ShotsRepositoryHttp {
    void getShotsList(String accessToken, JokeVO jokeVO);
}
