package com.bmss.redis;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by fengxuan1 on 2017/4/18.
 */
public class RedisSetTest {

    ClassPathXmlApplicationContext context;
    RedisSet redisSet;
    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("classpath:spring/spring-redis.xml");
        redisSet = context.getBean(RedisSet.class);
        redisSet.init();
    }

    @Test
    public void test(){
        redisSet.useSet();
    }

    @Test
    public void testIncrement(){
        System.out.println(redisSet.increment());
    }

}