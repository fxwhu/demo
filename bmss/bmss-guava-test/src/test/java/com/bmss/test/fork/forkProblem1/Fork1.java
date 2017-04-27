package com.bmss.test.fork.forkProblem1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by fengxuan1 on 2017/4/25.
 */
public class Fork1 {

    Lock lock;

    public Fork1() {
        this.lock = new ReentrantLock();
    }

    public boolean pickUp(){
        return lock.tryLock();
    }

    public void putDown(){
        lock.unlock();
    }
}
