package com.bmss.test.thread.volatileTest;

/**
 * Created by fengxuan1 on 2016/12/29.
 */
public class MainTest {

    public static void main(String[] args) throws InterruptedException {
        RunThread runThread = new RunThread();
        runThread.start();
        Thread.sleep(1000);
        runThread.setRunFlag(false);
        System.out.println("exit !");
    }
}
