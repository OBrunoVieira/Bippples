package com.example.brunovieira.bippples.model.event;

import com.example.brunovieira.bippples.model.entities.JokeVO;
import com.example.brunovieira.bippples.model.entities.ShotsVO;

import java.util.List;

/**
 * Created by bruno.vieira on 04/05/2016.
 */
public class ShotsResultEvent {
    private JokeVO jokeVO;
    private List<ShotsVO> shotsList;

    public ShotsResultEvent(JokeVO jokeVO, List<ShotsVO> shotsList) {
        this.jokeVO = jokeVO;
        this.shotsList = shotsList;
    }

    public JokeVO getJokeVO() {
        return jokeVO;
    }

    public List<ShotsVO> getShotsList() {
        return shotsList;
    }
}
