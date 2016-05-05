package com.example.brunovieira.bippples.model.event;

/**
 * Created by bruno.vieira on 03/05/2016.
 */
public class NetworkErrorEvent {
    private String errorDescription;

    public NetworkErrorEvent(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public String getErrorDescription() {
        return errorDescription;
    }
}
