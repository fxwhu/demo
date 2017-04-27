package com.bmss.test.thread.notify;

/**
 * Created by fengxuan1 on 2017/1/1.
 */
public class ThreadB extends Thread {

    private Object lock;

    public ThreadB(Object lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock){
                for (int i = 0; i < 10 ; i++) {
                    MyList.add("1");
                    if(MyList.getSize() == 5){
                        lock.notify();
                    }
                    System.out.println("添加第" + i + "个元素");
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
