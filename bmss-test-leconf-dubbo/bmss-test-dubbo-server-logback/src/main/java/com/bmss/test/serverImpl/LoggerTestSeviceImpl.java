package com.bmss.test.serverImpl;

import com.bmss.test.api.LoggerTestApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by fengxuan1 on 2016/12/27.
 */
@Component("loggerTest1")
public class LoggerTestSeviceImpl implements LoggerTestApi{
    private static Logger logger = LoggerFactory.getLogger(LoggerTestSeviceImpl.class);

    @Override
    public void test() {
        logger.info("logback sout info message");
        logger.debug("logback sout debug message");
    }
}
