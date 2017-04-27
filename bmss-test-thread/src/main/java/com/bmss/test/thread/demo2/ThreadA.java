package com.bmss.test.thread.demo2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by fengxuan1 on 2017/1/2.
 */
public class ThreadA extends Thread{

    private static Logger logger = LoggerFactory.getLogger(ThreadA.class);

    private ThreadB threadB;

    public ThreadA(ThreadB threadB){
        super();
        this.threadB = threadB;
    }

    @Override
    public void run() {
        try {
            synchronized (threadB){
                threadB.start();
                Thread.sleep(6000);
//                threadB.join(6000);
//                logger.info("=========");
                System.out.println("===========");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
