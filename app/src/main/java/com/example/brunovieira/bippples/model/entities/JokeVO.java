package com.example.brunovieira.bippples.model.entities;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.io.Serializable;

/**
 * Created by bruno.vieira on 04/05/2016.
 */
@JsonObject
public class JokeVO implements Serializable {

    private static final long serialVersionUID = -1050037489208143251L;

    @JsonField(name = "value")
    JokeValueVO jokeValueVO;

    public JokeVO() {
    }

    public JokeValueVO getJokeValueVO() {
        return jokeValueVO;
    }

    public void setJokeValueVO(JokeValueVO jokeValueVO) {
        this.jokeValueVO = jokeValueVO;
    }
}
