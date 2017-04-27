package com.bmss.redis;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

/**
 * Created by fengxuan1 on 2017/4/11.
 */
public class WatchTest1 {

    static Logger logger = LoggerFactory.getLogger(WatchTest.class);

    static RedisTemplate<String, String> redisTemplate;

    static ClassPathXmlApplicationContext context;


    public static void main(String[] args) {
        context = new ClassPathXmlApplicationContext("classpath:spring/spring-redis.xml");
        redisTemplate = context.getBean(RedisTemplate.class);
        redisTemplate.setEnableTransactionSupport(true);
        test();
    }



    public static void test(){
        redisTemplate.opsForValue().set("test", "1");

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                redisTemplate.watch("test");
                redisTemplate.multi();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                redisTemplate.opsForValue().increment("test", 2);
                List<Object> exec = redisTemplate.exec();
                logger.info(JSON.toJSONString(exec));
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Long test = redisTemplate.opsForValue().increment("test", 1);
                logger.info("test: " + test);
            }
        });
        thread.start();
        thread1.start();
    }
}
