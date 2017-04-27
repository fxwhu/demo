package com.bmss.redis;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

/**
 * Created by fengxuan1 on 2017/3/29.
 */
public class MyMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message, byte[] bytes) {
        System.out.println("channel:" + new String(message.getChannel())
                + ",message:" + new String(message.getBody()));
    }
}
