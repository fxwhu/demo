package com.bmss.test.thread.notify;

/**
 * Created by fengxuan1 on 2017/1/1.
 */
public class NotifyAndWait {
    public static void main(String[] args) throws InterruptedException {
        Object Lock = new Object();
        ThreadA threadA = new ThreadA(Lock);
        ThreadB threadB = new ThreadB(Lock);
        threadA.start();
        Thread.sleep(1000);
        threadB.start();
    }
}
