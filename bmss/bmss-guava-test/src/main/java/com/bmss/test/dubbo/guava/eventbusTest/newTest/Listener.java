package com.bmss.test.dubbo.guava.eventbusTest.newTest;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

/**
 * Created by fengxuan1 on 2016/11/13.
 */
public class Listener {
    EventBus eventBus = EventBusSingleton.getEventBus("test");

    public Listener() {
        eventBus.register(this);
    }

    @Subscribe
    public void listener(Watched watched){
        System.out.println(watched.getMessage());
    }
}
