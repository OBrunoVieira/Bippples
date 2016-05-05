package com.example.brunovieira.bippples.model.event;

/**
 * Created by bruno.vieira on 03/05/2016.
 */
public class Http5xxEvent {
    private String errorDescription;

    public Http5xxEvent(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public String getErrorDescription() {
        return errorDescription;
    }
}
