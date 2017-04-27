package com.bmss.test.dubbo.guava.eventbusTest;

import com.google.common.eventbus.Subscribe;

/**
 * Created by fengxuan1 on 2016/11/13.
 */
public class EventListener {

    public int lastMessage = 0;
    @Subscribe
    public void listen(TestEvent testEvent){
        lastMessage = testEvent.getMessage();
    }

    @Subscribe
    public void listen1(TestEvent testEvent){
        System.out.println("i listen the testEvent change" + testEvent.getMessage());
    }

    public int getLastMessage() {
        return lastMessage;
    }
}
