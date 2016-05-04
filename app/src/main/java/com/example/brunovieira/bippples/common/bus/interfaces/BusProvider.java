package com.example.brunovieira.bippples.common.bus.interfaces;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by bruno.vieira on 03/05/2016.
 */
public interface BusProvider {
    EventBus getServiceBus();

    void setServiceBus(EventBus serviceBus);

    EventBus getRepositoryBus();

    void setRepositoryBus(EventBus repositoryBus);
}
