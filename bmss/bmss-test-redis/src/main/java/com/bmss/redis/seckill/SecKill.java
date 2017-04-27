package com.bmss.redis.seckill;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

/**
 * Created by fengxuan1 on 2017/4/11.
 */

@Component
public class SecKill {

    static Logger logger = LoggerFactory.getLogger(SecKill.class);


    @Autowired
    RedisTemplate<String, String> redisTemplate;

    private static final String USERINFO = "userinfo:";

    public void init(){
        redisTemplate.opsForValue().set("gcode1", "10");
        redisTemplate.delete(USERINFO);
    }

    public void writeKillInfo(String useId){
        redisTemplate.watch("gcode1");
        String userInfo =  (String)redisTemplate.opsForHash().get(USERINFO, useId);
        if(userInfo != null){
            redisTemplate.unwatch();
            return;
        }
        String gcodenumString = redisTemplate.opsForValue().get("gcode1");

        Long num = Long.valueOf((String) redisTemplate.opsForValue().get("gcode1"));
        if(num == 0){
            redisTemplate.unwatch();
            return;
        }
        redisTemplate.multi();
        redisTemplate.opsForValue().increment("gcode1", -1);
        redisTemplate.opsForHash().put(USERINFO, useId, String.valueOf(System.currentTimeMillis()));
        List<Object> exec = redisTemplate.exec();
        logger.info(JSON.toJSONString(exec));
    }

    public void testGetNums(){
        redisTemplate.watch("gcode1");
        redisTemplate.multi();
        String gcodenumString = redisTemplate.opsForValue().get("gcode1");
        System.out.println("gcodenumString: " + gcodenumString);

//        Long num = Long.valueOf((String) redisTemplate.opsForValue().get("gcode1"));
//        if(num == 0){
//            redisTemplate.unwatch();
//            return;
//        }

        List<Object> exec = redisTemplate.exec();
        logger.info(JSON.toJSONString(exec));
    }


    public void fineGrainedLock() throws InterruptedException {
//        redisTemplate.multi();
        long beginTime = System.currentTimeMillis();
        String id = UUID.randomUUID().toString();
        while(System.currentTimeMillis() < beginTime + 1000){
            Boolean test = redisTemplate.opsForValue().setIfAbsent("testLock", id);
            if(test){
                //todo something cost 2s
                logger.info("thread: " + Thread.currentThread().getName() + " begin");
                Thread.sleep(100);
                logger.info("thread: " + Thread.currentThread().getName() + " end");
                releaseLock("testLock", id);
            }

        }

//        redisTemplate.expire("test", 1, TimeUnit.SECONDS);
//        List<Object> exec = redisTemplate.exec();
//        if(Boolean.valueOf((String)exec.get(0))){
    }


    public void releaseLock(String lockName, String value){
        while (true){
            redisTemplate.watch(lockName);
            String s = redisTemplate.opsForValue().get(lockName);
            if(s.equals(value)){
                redisTemplate.multi();
                redisTemplate.delete(lockName);
                redisTemplate.exec();
                break;
            }
            redisTemplate.unwatch();
        }
    }

    public void initFineGrainedLock(){
        redisTemplate.delete("test");
    }

}
