package com.bmss.test.fork.forkProblem2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by fengxuan1 on 2017/4/25.
 */
public class Fork2 {

    private static Logger logger = LoggerFactory.getLogger(Fork2.class);

    private boolean[] used = {false, false, false, false, false};


    Lock lock = new ReentrantLock();

    public Fork2() {
    }

    public void pickUp() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            int index = Integer.parseInt(Thread.currentThread().getName());
            if(!(used[index] || used[(index + 1) % 5])){
                used[index] = true;
                used[(index + 1) % 5] = true;
                logger.info(index + "=====");
            }else {
                used[index] = false;
                used[(index + 1) % 5] = false;
            }
        } finally {
            lock.unlock();
        }
    }

}
