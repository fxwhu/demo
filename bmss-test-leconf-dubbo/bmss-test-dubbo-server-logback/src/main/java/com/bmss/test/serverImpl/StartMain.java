package com.bmss.test.serverImpl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by fengxuan1 on 2016/12/27.
 */
public class StartMain {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring/applicationContext.xml");
        context.start();
        System.in.read();
    }
}
