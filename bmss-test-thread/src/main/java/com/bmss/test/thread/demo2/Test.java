package com.bmss.test.thread.demo2;

/**
 * Created by fengxuan1 on 2017/1/2.
 */
public class Test {


    public static void main(String[] args) {
        try {
            ThreadB threadB = new ThreadB();
            ThreadA threadA = new ThreadA(threadB);

            threadA.start();
            Thread.sleep(1000);
            ThreadC threadC = new ThreadC(threadB);
            threadC.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
