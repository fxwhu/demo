package com.bmss.redis;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

/**
 * Created by fengxuan1 on 2017/3/29.
 */
@RedisHash("person")
public class Person {

    @Id
    private String id;

    String firstName, lastName, address;
}
