package com.bmss.test.thread.synchron;

/**
 * Created by fengxuan1 on 2016/12/29.
 */
public class ThreadA extends Thread {
    Service service;

    public ThreadA(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        service.test();
    }
}
