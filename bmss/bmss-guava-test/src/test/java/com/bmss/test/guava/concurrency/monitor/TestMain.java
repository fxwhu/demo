package com.bmss.test.guava.concurrency.monitor;

import com.google.common.collect.Lists;

import java.util.ArrayList;

/**
 * Created by fengxuan1 on 2017/4/26.
 */
public class TestMain {

    public static void main(String[] args) {
        MonitorTest2 monitorTest2 = new MonitorTest2();
        ArrayList<Thread> threads = Lists.newArrayList();

        for (int i = 0; i < 20; i++) {
            MyThread1 myThread1 = new MyThread1(String.valueOf(i), monitorTest2);
            myThread1.start();
            threads.add(myThread1);
        }

        threads.get(0).interrupt();

        System.out.println("============");
    }
}
