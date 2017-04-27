package com.bmss.test.dubbo.guava.eventbusTest;

import com.google.common.eventbus.EventBus;

/**
 * Created by fengxuan1 on 2016/11/13.
 */
public class TestMain {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus("test");
        EventListener listener = new EventListener();

        eventBus.register(listener);

        eventBus.post(new TestEvent(200));

        System.out.println(listener.getLastMessage());
    }
}
