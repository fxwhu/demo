package com.bmss.redis;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.DefaultStringRedisConnection;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisZSetCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by fengxuan1 on 2017/4/18.
 */
@Component
public class RedisZset {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private final static String DESTINATION = "destination";

    private final static String MIN = "temp1";

    private final static String MAX = "temp2";

    public void aggregation(final double min, final double max){
        redisTemplate.executePipelined(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                DefaultStringRedisConnection stringRedisConnection = new DefaultStringRedisConnection (redisConnection);
                int[] ints = {1, 1};
                if(min > 0){
                    stringRedisConnection.zAdd(MIN, min, "min");
                    stringRedisConnection.zUnionStore(DESTINATION, RedisZSetCommands.Aggregate.MIN, ints, DESTINATION, MIN);
                    stringRedisConnection.zIncrBy(DESTINATION, min, "sum");
                    stringRedisConnection.zIncrBy(DESTINATION, 1, "count");
                }
                if(max > 0){
                    stringRedisConnection.zAdd(MAX, max, "max");
                    stringRedisConnection.zUnionStore(DESTINATION, RedisZSetCommands.Aggregate.MAX, ints, DESTINATION, MAX);
                    stringRedisConnection.zIncrBy(DESTINATION, max, "sum");
                    stringRedisConnection.zIncrBy(DESTINATION, 1, "count");
                }
                return null;
            }
        });
    }


    public void init(){
        redisTemplate.delete(Lists.newArrayList(DESTINATION, MIN, MAX));
        redisTemplate.opsForZSet().add(DESTINATION, "min", 100);
        redisTemplate.opsForZSet().add(DESTINATION, "max", 2000);
        redisTemplate.opsForZSet().add(DESTINATION, "sum", 10000);
        redisTemplate.opsForZSet().add(DESTINATION, "count", 10);
    }

}
