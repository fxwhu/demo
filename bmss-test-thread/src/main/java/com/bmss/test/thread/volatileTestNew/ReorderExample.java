package com.bmss.test.thread.volatileTestNew;

/**
 * Created by fengxuan1 on 2017/2/21.
 */
public class ReorderExample {

    int a = 0;

    boolean flag = false;

    int m = 2;

    public void test() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                write();
            }
        });
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                read();
            }
        });

        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
        System.out.println("=====" + m);
    }

    public void write(){
        a = 1;
        flag = true;
    }

    public void read(){
        if(flag){
            m = a * a;
        }
    }
}
