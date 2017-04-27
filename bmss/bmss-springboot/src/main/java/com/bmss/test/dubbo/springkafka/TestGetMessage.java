package com.bmss.test.dubbo.springkafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * Created by fengxuan1 on 2016/10/31.
 */
public class TestGetMessage {
    @Autowired
    KafkaTemplate<Integer, String> kafkaTemplate;

    private final static String TOPIC = "test";


}
