package com.bmss.test.dubbo.guava.eventbusTest.newTest;

/**
 * Created by fengxuan1 on 2016/11/13.
 */
public class TestMain {

    public static void main(String[] args) {
        Listener listener = new Listener();
        Watched watched = new Watched("init the wacthed");
        watched.setMessage("change the wacthed second");
    }
}
