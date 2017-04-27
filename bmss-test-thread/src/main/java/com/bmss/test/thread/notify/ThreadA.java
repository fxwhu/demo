package com.bmss.test.thread.notify;

/**
 * Created by fengxuan1 on 2017/1/1.
 */
public class ThreadA extends Thread{

    private Object lock;

    public ThreadA(Object lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock){
                System.out.println("start in");
                if(MyList.getSize() < 5){
                    lock.wait();
                    System.out.println("out");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
