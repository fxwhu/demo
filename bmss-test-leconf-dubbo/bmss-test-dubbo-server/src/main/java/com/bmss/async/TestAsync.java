package com.bmss.async;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Created by fengxuan1 on 2017/3/13.
 */
@Component
public class TestAsync extends ApplicationObjectSupport {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(TestAsync.class);
    @Autowired
    Test test;

    public void test1(){
        logger.info("1");
//        ((TestAsync) AopContext.currentProxy()).test3();
        getApplicationContext().getBean(TestAsync.class).test3();
//        test3();
        test.test2();
        logger.info("2");
    }


    @Async
    public void test3(){
        try {
            Thread.sleep(1000* 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("4");
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        long time = startTime + 1000;
        while (System.currentTimeMillis() < time){

        }
        logger.info("end" + ". start at: " + startTime + " ,end: " + System.currentTimeMillis());
    }


}
