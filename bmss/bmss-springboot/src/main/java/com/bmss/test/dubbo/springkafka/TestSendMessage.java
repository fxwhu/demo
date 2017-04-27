package com.bmss.test.dubbo.springkafka;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * Created by fengxuan1 on 2016/10/31.
 */
@Component
public class TestSendMessage {
    @Autowired
    KafkaTemplate<Integer, String> kafkaTemplate;

    private final static String TOPIC = "test";

    public void sendMessage(String message) {
        ListenableFuture<SendResult<Integer, String>> future = kafkaTemplate.send(TOPIC, message);
        future.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                ex.printStackTrace();
            }
            @Override
            public void onSuccess(SendResult<Integer, String> result) {
                //todo something 获取
            }
        });
    }
}
