package com.bmss.db.redis;

import com.alibaba.fastjson.JSON;
import com.bmss.db.pojo.Student;
import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by fengxuan1 on 2017/5/2.
 */
public class RedisCache implements Cache{

    private static Logger logger = LoggerFactory.getLogger(RedisCache.class);

    private static ApplicationContext context;

    private static RedisTemplate redisTemplate;

    private String id;

    private final static String NAMESPACE = "mybatis_cache:";

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock(); //读写锁

    static {
        context = new ClassPathXmlApplicationContext("classpath:springMybatis/spring-redis.xml");
        redisTemplate = context.getBean(RedisTemplate.class);
    }


    public RedisCache(final String id) {
        if(id==null) {
            throw new IllegalArgumentException("Cache instance requires an ID");
        }
        logger.debug("create an cache instance with id: " + id);
        this.id=id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void putObject(Object key, Object value) {
        logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>putObject: " + key + "=" + value);
        redisTemplate.opsForHash().put(NAMESPACE, key.toString(), JSON.toJSONString(value));
    }

    @Override
    public Object getObject(Object key) {
        logger.debug(">>>>>>>>>>>>>>>>>>>>>>>> getObject: " + key);
        return JSON.parseArray((String) redisTemplate.opsForHash().get(NAMESPACE, key.toString()), Student.class);
    }

    @Override
    public Object removeObject(Object key) {
        return redisTemplate.opsForHash().delete(NAMESPACE, key.toString());
    }

    @Override
    public void clear() {
        redisTemplate.delete(NAMESPACE);
    }

    @Override
    public int getSize() {
        return redisTemplate.opsForHash().keys(NAMESPACE).size();
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }
}
