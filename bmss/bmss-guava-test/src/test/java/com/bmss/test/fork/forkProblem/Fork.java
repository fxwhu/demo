package com.bmss.test.fork.forkProblem;

import com.google.common.util.concurrent.Monitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by fengxuan1 on 2017/4/25.
 */
public class Fork {

    private static Logger logger = LoggerFactory.getLogger(Fork.class);


    private boolean[] used = {false, false, false, false, false};

    private boolean left, right;

    private Monitor monitor = new Monitor();

    Monitor.Guard cantake = new Monitor.Guard(monitor){
        @Override
        public boolean isSatisfied() {
            return !(left || right);
        }
    };


    public void takeFork() throws InterruptedException {
        int index = Integer.parseInt(Thread.currentThread().getName());
        right = used[index];
        left = used[(index + 1) % 5];
        monitor.enterWhen(cantake);
        try {
            right = true;
            left = true;
            used[index] = true;
            used[(index + 1) % 5] = true;
            logger.info("第" + index + "个哲学家拿到了筷子");
        } finally {
            monitor.leave();
        }
    }

    public void putFork(){
        int index = Integer.parseInt(Thread.currentThread().getName());
        right = false;
        left = false;
        used[index] = false;
        used[(index + 1) % 5] = false;
    }
}
