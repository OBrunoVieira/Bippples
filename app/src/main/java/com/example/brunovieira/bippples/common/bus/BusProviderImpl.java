package com.example.brunovieira.bippples.common.bus;

import com.example.brunovieira.bippples.common.bus.interfaces.BusProvider;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EBean;
import org.greenrobot.eventbus.EventBus;

/**
 * Created by bruno.vieira on 03/05/2016.
 */
@EBean(scope = EBean.Scope.Singleton)
public class BusProviderImpl implements BusProvider {
    private EventBus serviceBus;
    private EventBus repositoryBus;

    @AfterInject
    public void afterInject(){
        serviceBus = new EventBus();
        repositoryBus = new EventBus();
    }

    @Override
    public EventBus getServiceBus() {
        return serviceBus;
    }

    @Override
    public void setServiceBus(EventBus serviceBus) {
        this.serviceBus = serviceBus;
    }

    @Override
    public EventBus getRepositoryBus() {
        return repositoryBus;
    }

    @Override
    public void setRepositoryBus(EventBus repositoryBus) {
        this.repositoryBus = repositoryBus;
    }
}
