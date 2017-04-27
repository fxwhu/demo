package com.bmss.test.dubbo.logTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by fengxuan1 on 2016/12/1.
 */
public class TestLog {
    static Logger logger = LoggerFactory.getLogger(TestLog.class);

    public static void main(String[] args) {
        logger.info("=====");
    }
}
