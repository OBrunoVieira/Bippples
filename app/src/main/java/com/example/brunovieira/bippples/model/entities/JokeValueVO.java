package com.example.brunovieira.bippples.model.entities;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.io.Serializable;

/**
 * Created by bruno.vieira on 04/05/2016.
 */
@JsonObject
public class JokeValueVO implements Serializable {

    private static final long serialVersionUID = 2783376682362933531L;

    @JsonField(name = "joke")
    private String jokeDescription;

    public JokeValueVO() {
    }

    public String getJokeDescription() {
        return jokeDescription;
    }

    public void setJokeDescription(String jokeDescription) {
        this.jokeDescription = jokeDescription;
    }
}
