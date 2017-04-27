package com.bmss.redis;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by fengxuan1 on 2017/3/13.
 */
@Component
public class MarketTrade {
    private final static String MARKET = "market:";
    private final static String USER = "user:";
    private final static String INVENTORY = "inventory:";

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    public boolean sell(String sellerId, String item, double price){
        String marketItem = item + "." + sellerId;
        long endTime = System.currentTimeMillis() + 5;
        while(System.currentTimeMillis() < endTime){
            try {
                redisTemplate.watch(INVENTORY + sellerId);
                if(!redisTemplate.opsForSet().isMember(INVENTORY + sellerId, item)){
                    redisTemplate.unwatch();
                    return false;
                }
                redisTemplate.multi();
                redisTemplate.opsForZSet().add(MARKET, marketItem, price);
                redisTemplate.opsForSet().remove(INVENTORY + sellerId, item);
                redisTemplate.exec();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
        return false;
    }

    public boolean buy(String sellerId, String buyerId, String item){
        String marketItem = item + "." + sellerId;
        redisTemplate.watch(Lists.newArrayList(USER, MARKET));
        Double funds = Double.valueOf((String)redisTemplate.opsForHash().get(USER, "funds"));
        Double price = redisTemplate.opsForZSet().score(MARKET, marketItem);
        if(funds != null && price < funds){
            try {
                redisTemplate.multi();
                redisTemplate.opsForZSet().remove(MARKET, marketItem);
                redisTemplate.opsForHash().increment(USER + buyerId, "funds", (-1) * price);
                redisTemplate.opsForHash().increment(USER + sellerId, "funds", price);
                redisTemplate.opsForSet().add(INVENTORY + buyerId, item);
                redisTemplate.exec();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }else {
            redisTemplate.unwatch();
            return false;
        }
    }


    public void createUserAccount(User user){
        String id = user.getId();
        String name = user.getName() == null ?  "" : user.getName();
        redisTemplate.opsForHash().put(USER + id, "name", name);
        redisTemplate.opsForHash().put(USER + id, "funds", user.getFunds());
    }

    public void createInventory(String userId, String item){
        redisTemplate.opsForSet().add(INVENTORY + userId, item);
    }

}
