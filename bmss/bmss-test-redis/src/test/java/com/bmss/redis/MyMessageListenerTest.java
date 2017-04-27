package com.bmss.redis;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;
import java.util.Set;

/**
 * Created by fengxuan1 on 2017/3/29.
 */
public class MyMessageListenerTest {
    ClassPathXmlApplicationContext context;
    MessageSubAndReceiving messageSubAndReceiving;
    RedisTemplate<String, String> redisTemplate;


    @Before
    public void init(){
        context = new ClassPathXmlApplicationContext("classpath:spring/spring-redis.xml");
        messageSubAndReceiving = context.getBean(MessageSubAndReceiving.class);
        redisTemplate = context.getBean(RedisTemplate.class);
    }


    @Test
    public void sendMessage() throws InterruptedException {
        messageSubAndReceiving.sendMessage("hello.111", "hello");
        messageSubAndReceiving.sendMessage("springtv", "hello");
        messageSubAndReceiving.sendMessage("spring", "hello");
        messageSubAndReceiving.sendMessage("tvtv1", "hello");
        Thread.sleep(5000);
    }

    @Test
    public void getAllKey(){
//        Set<String> keys = redisTemplate.keys("spring:session:sessions*");
        Set<String> keys = redisTemplate.keys("redis_canal_key_");
//        Set<String> keys = redisTemplate.keys("allResources");
        for (String key: keys) {
            System.out.println("====" + key);
            DataType type = redisTemplate.type(key);


            System.out.println(type);

            Map<Object, Object> entries = redisTemplate.opsForHash().entries(key);
            for(Object mapkey: entries.keySet()){
                System.out.println("=====" + (String) entries.get(mapkey) + " ,==" + (String)mapkey);
            }
            System.out.println("====");
        }
    }


    @Test
    public void getHashValue(){
        Object redis_canal_key_ = redisTemplate.opsForHash().get("redis_canal_key_", "dbhub-10.120.133.51:3306!_*_!test_mycat!_*_!test_gzy");
        System.out.println((String) redis_canal_key_);
    }

    @Test
    public void put(){
//        redisTemplate.opsForHash().put("redis_canal_key_", "dbhub-10.120.133.51!_*_!test_mycat!_*_!test_gzy", "TESTDB_LY");
        redisTemplate.delete("redis_canal_key_");
    }


    @Test
    public void remove(){
        redisTemplate.opsForHash().delete("redis_canal_key_", "dbhub-10.120.141.139:3306!_*_!test!_*_!stress_init_2");
    }
}