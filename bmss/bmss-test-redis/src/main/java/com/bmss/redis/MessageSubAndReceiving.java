package com.bmss.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by fengxuan1 on 2017/3/29.
 */
@Component
public class MessageSubAndReceiving {

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    /**
     *订阅
     */
    public void sendMessage(String channel, String message){
        redisTemplate.convertAndSend(channel, message);
    }
}
