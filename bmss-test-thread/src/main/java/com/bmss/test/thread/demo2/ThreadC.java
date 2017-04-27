package com.bmss.test.thread.demo2;

/**
 * Created by fengxuan1 on 2017/1/2.
 */
public class ThreadC extends Thread {

    private ThreadB threadB;

    public ThreadC(ThreadB threadB){
        super();
        this.threadB = threadB;
    }

    @Override
    public void run() {
        threadB.test();
    }
}
