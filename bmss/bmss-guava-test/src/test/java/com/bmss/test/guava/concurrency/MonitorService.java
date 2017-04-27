package com.bmss.test.guava.concurrency;

import com.google.common.util.concurrent.Monitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by fengxuan1 on 2017/4/25.
 */
public class MonitorService {
    private static Logger logger = LoggerFactory.getLogger(MonitorService.class);

    private final Monitor monitor =  new Monitor();

    private Integer i;

    private final Monitor.Guard valuePresent = new Monitor.Guard(monitor){

        @Override
        public boolean isSatisfied() {
            return i != null;
        }
    };


    private final Monitor.Guard valueAbsent = new Monitor.Guard(monitor){

        @Override
        public boolean isSatisfied() {
            return i == null;
        }
    };


    public int get() throws InterruptedException {
        logger.info("start get");
        monitor.enterWhen(valuePresent);
        try {
            int result = i;
            i = null;
            logger.info("end get: " + result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            monitor.leave();
        }
    }


    public void set(int value) throws InterruptedException {
        logger.info("start set: " + value);
        monitor.enterWhen(valueAbsent);
        try {
            i = value;
            Thread.sleep(10000);
            logger.info("end set");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            monitor.leave();
        }
    }

}
