package com.bmss.test.thread.demo2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by fengxuan1 on 2017/1/2.
 */
public class ThreadB extends Thread {
    private static Logger logger = LoggerFactory.getLogger(ThreadB.class);

    @Override
    public void run() {
        try {
//            logger.info("run begin");
            System.out.println("run begin");
            Thread.sleep(5000);
//            logger.info("run end");
            System.out.println("run end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    synchronized public void test(){
//        logger.info("print bservice!");
        System.out.println("print bservice!");
    }

}
