package com.bmss.LocalThreadDemos;

/**
 * Created by fengxuan1 on 2017/1/17.
 */
public class MainTest {

    static ThreadLocalDemo threadLocalDemo = new ThreadLocalDemo();


    static String otherParam = "100";

    public static void main(String[] args) throws InterruptedException {
        Object value2 = threadLocalDemo.get();
        threadLocalDemo.set("50");
        System.out.println("main value: " + value2 + ", otherParam: " + otherParam);
        otherParam = "40";
        Thread.sleep(1000);



        Thread thread = new Thread(new Runnable() {
//            ThreadLocalDemo threadLocalDemo = new ThreadLocalDemo();
            @Override
            public void run() {
                Object value = threadLocalDemo.get();
                System.out.println(Thread.currentThread().getName() + ": " + value + ", otherParam: " + otherParam);
                threadLocalDemo.set("30");
                otherParam = "50";
            }
        });
        thread.setName("ThreadA");
        thread.start();

    }
}
