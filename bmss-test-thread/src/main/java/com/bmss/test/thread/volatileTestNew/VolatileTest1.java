package com.bmss.test.thread.volatileTestNew;

/**
 * Created by fengxuan1 on 2017/2/21.
 */
public class VolatileTest1 {

    public static void main(String[] args) {
        Server server = new Server(1);
        ThreadTest threadTest = new ThreadTest(server);
        ThreadTest threadTest1 = new ThreadTest(server);
        ThreadTest threadTest2 = new ThreadTest(server);
        ThreadTest threadTest3 = new ThreadTest(server);
        ThreadTest threadTest4 = new ThreadTest(server);

        threadTest.start();
        threadTest1.start();
        threadTest2.start();
        threadTest3.start();
        threadTest4.start();


    }
}
