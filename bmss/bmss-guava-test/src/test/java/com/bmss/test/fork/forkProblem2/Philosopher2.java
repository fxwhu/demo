package com.bmss.test.fork.forkProblem2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by fengxuan1 on 2017/4/25.
 */
public class Philosopher2 extends Thread {

    private static Logger logger = LoggerFactory.getLogger(Philosopher2.class);

    private Fork2 fork2;

    public Philosopher2(Fork2 fork2) {
        this.fork2 = fork2;
    }

    @Override
    public void run() {
        try {
            fork2.pickUp();
        } catch (InterruptedException e) {
            e.printStackTrace();
            logger.info("error");
        }
    }
}
