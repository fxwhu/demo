package com.bmss.test.guava.concurrency.monitor;

/**
 * Created by fengxuan1 on 2017/4/26.
 */
public class MyThread1 extends Thread{

    String item;

    MonitorTest2 monitorTest2;

    public MyThread1(String item, MonitorTest2 monitorTest2) {
        this.item = item;
        this.monitorTest2 = monitorTest2;
    }

    @Override
    public void run() {
        try {
            monitorTest2.addToList(item);
        } catch (InterruptedException e) {
            System.out.println("interrupt");
            e.printStackTrace();
        }
    }
}
