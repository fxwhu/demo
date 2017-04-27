package com.bmss.test;

import com.bmss.test.api.LoggerTestApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by fengxuan1 on 2016/12/27.
 */
public class LoggerTestClient {

    private static Logger logger = LoggerFactory.getLogger(LoggerTestClient.class);

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext-dubbo-consumer.xml");
        LoggerTestApi bean = applicationContext.getBean(LoggerTestApi.class);
        while(true){
            bean.test();
            Thread.sleep(10000);
        }
    }
}
