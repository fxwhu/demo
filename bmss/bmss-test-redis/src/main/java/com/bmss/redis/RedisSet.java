package com.bmss.redis;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by fengxuan1 on 2017/4/18.
 */

@Component
public class RedisSet {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void init(){
        redisTemplate.delete(Lists.<String>newArrayList("setkey1", "setkey1", "setkey3", "setkey4"));
        redisTemplate.opsForSet().add("setkey1", "jetty", "tom", "luence");
        redisTemplate.opsForSet().add("setkey2", "feng", "tom", "luence");
    }

    public void useSet(){
        //交集
        redisTemplate.opsForSet().intersectAndStore("setkey1", "setkey2", "setkey3");
        //并集
        redisTemplate.opsForSet().unionAndStore("setkey1", "setkey2", "setkey4");
    }


    public long increment(){
        redisTemplate.opsForValue().set("test", "1");
        Long test = redisTemplate.opsForValue().increment("test", 10);
        return test;
    }
}
