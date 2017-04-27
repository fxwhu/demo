package com.bmss.test.dubbo.guava.eventbusTest.newTest;

import com.google.common.eventbus.EventBus;

/**
 * Created by fengxuan1 on 2016/11/13.
 */
public class Watched {
    EventBus eventBus = EventBusSingleton.getEventBus("test");
    private String message;

    public Watched() {
    }

    public Watched(String message) {
        this.message = message;
        eventBus.post(this);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        eventBus.post(this);
    }
}
