package com.bmss.test.serviceImpl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by fengxuan1 on 2016/12/27.
 */
public class StartMain {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring/applicationContext.xml");
        context.start();
        /*while (true){
            String address = clientDemo.getAddress();
            boolean flag = clientDemo.isFlag();
            System.out.println(address + ": " + flag);
//            String address = clientDemo.getAddress();
//            System.out.println(JSON.toJSONString(address));
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
            }
        }*/
        System.in.read();
    }
}
