package com.bmss.test.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by fengxuan1 on 2016/12/28.
 */
public class TestLog {

    private static Logger logger = LoggerFactory.getLogger(TestLog.class);
    public static void main(String[] args) throws InterruptedException {
        while (true){
            logger.info("info message");
            logger.debug("debugger message");
            Thread.sleep(10000);
        }
    }
}
