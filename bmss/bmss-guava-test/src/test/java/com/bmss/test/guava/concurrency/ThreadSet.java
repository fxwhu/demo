package com.bmss.test.guava.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by fengxuan1 on 2017/4/25.
 */
public class ThreadSet extends Thread{
    private static Logger logger = LoggerFactory.getLogger(ThreadGet.class);

    int value;

    MonitorService monitorService;

    public ThreadSet(int value, MonitorService monitorService) {
        this.value = value;
        this.monitorService = monitorService;
    }

    public void run() {
        try {
            monitorService.set(value);
        } catch (InterruptedException e) {
            logger.error("setThread error");
        }
    }
}
