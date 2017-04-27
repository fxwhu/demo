package com.bmss.redis.lua;

import com.bmss.lua.RedisLua;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by fengxuan1 on 2017/4/21.
 */
public class RedisLuaTest {

    ClassPathXmlApplicationContext context;
    RedisLua redisLua;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("classpath:spring/spring-redis.xml");
        redisLua = context.getBean(RedisLua.class);
    }

    @Test
    public void limitIp() throws Exception {
        long begin = System.currentTimeMillis();
        String result = redisLua.limitIp("10.120.120.1");
//        String result = redisLua.limitIp("setkey1");
        System.out.println(result + " ," + (System.currentTimeMillis() - begin));
    }

}