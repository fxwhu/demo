package com.bmss.test.thread.synchron;

/**
 * Created by fengxuan1 on 2016/12/29.
 */
public class MainTest {

    public static void main(String[] args) throws InterruptedException {
        ThreadA thread = new ThreadA(new Service());
        thread.setName("a");
        thread.start();
        thread.sleep(1000);
        ThreadA thread2 = new ThreadA(new Service());
        thread2.setName("b");
        thread2.start();
    }
}
