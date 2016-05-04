package com.example.brunovieira.bippples.domain.interfaces;

import com.example.brunovieira.bippples.model.entities.JokeVO;
import com.example.brunovieira.bippples.model.entities.ShotsVO;
import com.example.brunovieira.bippples.model.event.ShotsResultEvent;

import org.greenrobot.eventbus.Subscribe;

import java.util.List;

/**
 * Created by bruno.vieira on 28/03/2016.
 */
public interface HomeService {
    void getShotsList();

    @Subscribe
    void onJokeResult(JokeVO jokeVO);

    @Subscribe
    void onShotsResult(ShotsResultEvent shotsResultEvent);
}
