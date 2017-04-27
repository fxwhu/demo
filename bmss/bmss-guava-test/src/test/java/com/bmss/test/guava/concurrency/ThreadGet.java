package com.bmss.test.guava.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by fengxuan1 on 2017/4/25.
 */
public class ThreadGet extends Thread {

    private static Logger logger = LoggerFactory.getLogger(ThreadGet.class);

    MonitorService monitorService;

    public ThreadGet(MonitorService monitorService) {
        this.monitorService = monitorService;
    }

    @Override
    public void run() {
        try {
            monitorService.get();
        } catch (InterruptedException e) {
            logger.error("getThread error");
        }
    }

}
