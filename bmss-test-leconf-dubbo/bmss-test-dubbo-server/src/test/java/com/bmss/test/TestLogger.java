package com.bmss.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by fengxuan1 on 2016/12/27.
 */
public class TestLogger {

    private static Logger logger = LoggerFactory.getLogger(TestLogger.class);

    public static void main(String[] args) throws InterruptedException {
        /*ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring/applicationContext.xml");
        context.start();
        while (true){
            logger.info("info message");
            logger.debug("debugger message");
            Thread.sleep(10000);
        }*/
        logger.info("info message");
        logger.debug("info message");
    }
}
