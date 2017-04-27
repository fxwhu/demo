package com.bmss.test.dubbo.guava.eventbusTest.newTest;

import com.google.common.eventbus.EventBus;

/**
 * Created by fengxuan1 on 2016/11/13.
 */
public class EventBusSingleton {

    private volatile static EventBus eventBus;

    private EventBusSingleton(){}

    public static EventBus getEventBus(String eventName){
        if(eventBus == null){
            synchronized (EventBusSingleton.class){
                if(eventBus == null){
                    eventBus = new EventBus(eventName);
                }
            }
        }
        return eventBus;
    }
}
