package com.bmss.redis;

import com.alibaba.fastjson.JSON;
import com.bmss.redis.seckill.SecKill;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

/**
 * Created by fengxuan1 on 2017/4/11.
 */
public class WatchTest {

    static Logger logger = LoggerFactory.getLogger(WatchTest.class);

    RedisTemplate<String, String> redisTemplate;

    ClassPathXmlApplicationContext context;

    SecKill secKill;

    @Before
    public void init(){
        context = new ClassPathXmlApplicationContext("classpath:spring/spring-redis.xml");
        redisTemplate = context.getBean(RedisTemplate.class);
        secKill = context.getBean(SecKill.class);
    }

    @Test
    public void putAsString(){
        redisTemplate.opsForValue().set("test", "1");
    }

    @Test
    public void testWatch() throws InterruptedException {
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
                System.out.println(JSON.toJSONString(exec));
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                redisTemplate.opsForValue().increment("test", 1);
            }
        });
        thread.start();
        thread1.start();
    }


    @Test
    public void getString(){
        Long nums = Long.valueOf((String) redisTemplate.opsForValue().get("gcode1"));
        System.out.println(nums);
    }

    @Test
    public void testSecKill(){
//        secKill.writeKillInfo("userid" + "0");
        secKill.testGetNums();
    }






}
