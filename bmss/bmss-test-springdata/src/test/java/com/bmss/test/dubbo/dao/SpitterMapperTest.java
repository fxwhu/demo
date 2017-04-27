package com.bmss.test.dubbo.dao;

import com.bmss.test.dubbo.entity.Spitter;
import com.alibaba.fastjson.JSON;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

/**
 * Created by fengxuan1 on 2016/12/1.
 */
public class SpitterMapperTest {

    SpitterMapper spitterMapper;

    @org.junit.Before
    public void setUp() throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-context" +
                ".xml");
        spitterMapper = context.getBean(SpitterMapper.class);

    }

    @org.junit.Test
    public void testGetByName() throws Exception {
        Spitter spitter = new Spitter("fx", "12343", "fengxuan", "fengxuan@qq.com", true);
        Spitter spitter1 = new Spitter("fx1", "12343", "fengxuan", "fengxuan@qq.com", true);
        Spitter spitter2 = new Spitter("fx2", "12343", "fengxuan", "fengxuan@qq.com", true);
        Spitter spitter3 = new Spitter("fx3", "12343", "fengxuan", "fengxuan@qq.com", true);
        spitterMapper.insertBatch(Arrays.asList(spitter, spitter1, spitter2, spitter3));

        Spitter fx = spitterMapper.getByName("fx");
        System.out.println(JSON.toJSONString(fx));

        List<Spitter> all = spitterMapper.getAll();
        System.out.println(JSON.toJSONString(all));
    }
}