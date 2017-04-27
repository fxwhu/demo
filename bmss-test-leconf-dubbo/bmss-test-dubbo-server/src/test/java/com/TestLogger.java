package com;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by fengxuan1 on 2017/4/13.
 */
public class TestLogger {

    private static Logger logger = LoggerFactory.getLogger(TestLogger.class);
    @Test
    public void loggerTest(){
        try {
            int i = 10 / 0;
        } catch (Exception e) {
            logger.info("error", e.fillInStackTrace());
        }
    }

    @Test
    public void testBreak(){
        while (true){
            System.out.println("1");
            break;
        }
    }
}
