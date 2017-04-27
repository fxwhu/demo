package com.bmss.test.dubbo.guava.eventbusTest;

/**
 * Created by fengxuan1 on 2016/11/13.
 */
public class TestEvent {
    private final int message;

    public TestEvent(int message) {
        this.message = message;
    }

    public int getMessage() {
        return message;
    }
}
