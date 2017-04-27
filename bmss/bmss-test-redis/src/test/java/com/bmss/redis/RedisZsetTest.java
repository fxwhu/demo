package com.bmss.redis;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by fengxuan1 on 2017/4/18.
 */
public class RedisZsetTest {

    ClassPathXmlApplicationContext context;

    RedisZset redisZset;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("classpath:spring/spring-redis.xml");
        redisZset = context.getBean(RedisZset.class);
        redisZset.init();
    }

    @Test
    public void testPipelined(){
        redisZset.aggregation(10, 700);
    }

}