package com.bmss.async;

import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Created by fengxuan1 on 2017/3/13.
 */
@Component
public class Test {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(Test.class);
    @Async
    public void test2(){
        try {
            Thread.sleep(1000 * 5);
            logger.info("3");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
