package com.bmss.test.guava.concurrency.monitor;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Monitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by fengxuan1 on 2017/4/26.
 */
public class MonitorTest2 {

    private static Logger logger = LoggerFactory.getLogger(MonitorTest2.class);

    Monitor monitor = new Monitor();

    private static int SIZE = 10;

    private List<String> list = Lists.newArrayList();

    Monitor.Guard canAdd = new Monitor.Guard(monitor){

        @Override
        public boolean isSatisfied() {
            return list.size() < SIZE;
        }
    };

    public void addToList(String item) throws InterruptedException {
        monitor.enterWhen(canAdd);
        try {
            Thread.sleep(1000);
            logger.info("add: " + item);
            list.add(item);
            logger.info("" + list);
        } finally {
            monitor.leave();
        }
    }
}

