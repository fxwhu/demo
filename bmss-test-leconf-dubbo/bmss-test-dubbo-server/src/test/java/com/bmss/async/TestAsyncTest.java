package com.bmss.async;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by fengxuan1 on 2017/3/13.
 */
public class TestAsyncTest {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext.xml");
        TestAsync testAsync = context.getBean(TestAsync.class);
        testAsync.test1();

    }

}