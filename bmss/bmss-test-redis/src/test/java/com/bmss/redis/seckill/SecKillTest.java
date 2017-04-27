package com.bmss.redis.seckill;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by fengxuan1 on 2017/4/11.
 */
public class SecKillTest {


    static Logger logger = LoggerFactory.getLogger(SecKillTest.class);



    public static void main(String[] args) {
//        init();
        SecKillTest secKillTest = new SecKillTest();
        secKillTest.testThreads();
    }


    public static void init(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-redis.xml");
        SecKill secKill = context.getBean(SecKill.class);
//        secKill.initFineGrainedLock();
    }

    public void testThreads(){

        for (int i = 0; i < 20; i++) {
            ThreadSec threadSec = new ThreadSec("userId" + i);
            threadSec.start();
        }
    }


    class ThreadSec extends Thread{
        private  String userId;

        public ThreadSec(String userId){
            this.userId = userId;
        }

        @Override
        public void run() {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-redis.xml");
            SecKill secKill = context.getBean(SecKill.class);
//            secKill.writeKillInfo(userId);
            try {
                secKill.fineGrainedLock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}