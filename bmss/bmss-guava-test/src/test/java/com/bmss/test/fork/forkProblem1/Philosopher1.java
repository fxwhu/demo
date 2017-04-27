package com.bmss.test.fork.forkProblem1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by fengxuan1 on 2017/4/25.
 */
public class Philosopher1 extends Thread{

    private static Logger logger = LoggerFactory.getLogger(Philosopher1.class);

    private int size = 10;

    private Fork1 left;

    private Fork1 right;

    public Philosopher1(Fork1 left, Fork1 right) {
        this.left = left;
        this.right = right;
    }

    public void eat() throws InterruptedException {
        if(pickUp()){
            logger.info("拿到筷子");
            Thread.sleep(1000);
            putDown();
        }

    }

    public boolean pickUp(){
        if(!left.pickUp())
            return false;
        if(!right.pickUp()) {
            left.putDown();
            return false;
        }
        return true;
    }

    public void putDown(){
        left.putDown();
        right.putDown();
    }

    @Override
    public void run() {
        for (int i = 0; i < size; i++) {
            try {
                eat();
            } catch (InterruptedException e) {
                logger.info("error");
            }
        }
    }
}
