package com.bmss.LocalThreadDemos;

import static com.bmss.LocalThreadDemos.MainTest.otherParam;

/**
 * Created by fengxuan1 on 2017/1/17.
 */
public class MainTest1 {

    static InheritableThreadLocalTest threadLocalDemo = new InheritableThreadLocalTest();



    public static void main(String[] args) throws InterruptedException {

        Object value2 = threadLocalDemo.get();
        threadLocalDemo.set("50");
        System.out.println("main value: " + value2);
        Thread.sleep(1000);


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                    Object value = threadLocalDemo.get();
                    System.out.println(Thread.currentThread().getName() + ": " + value);
                    threadLocalDemo.set("30");
                    otherParam = "50";
            }
        });
        thread.setName("ThreadA");
        thread.start();
    }
}
