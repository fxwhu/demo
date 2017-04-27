package com.bmss.test.thread.volatileTestNew;

/**
 * Created by fengxuan1 on 2017/2/21.
 */
public class ThreadTest extends Thread{

    Server server;

    public ThreadTest(Server server) {
        this.server = server;
    }


    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        server.setNums(server.getNums() + 1);
        System.out.println("=======" + server.getNums());
    }
}
