package com.example.brunovieira.bippples.model.event;

/**
 * Created by bruno.vieira on 03/05/2016.
 */
public class UnexpectedErrorEvent {
    private String errorDescription;

    public UnexpectedErrorEvent(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public String getErrorDescription() {
        return errorDescription;
    }
}
