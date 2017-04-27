package com.bmss.test.dubbo.service.impl;

import com.bmss.test.dubbo.dao.SpitterMapper;
import com.bmss.test.dubbo.entity.Spitter;
import com.bmss.test.dubbo.service.SpitterService;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by fengxuan1 on 2016/12/5.
 */
@Service
public class SpitterServiceImpl implements SpitterService{
    @Autowired
    SpitterMapper spitterMapper;
    @Transactional(rollbackFor = IllegalArgumentException.class)
    @Override
    public void testTransaction() {
        spitterMapper.insertBatch(Lists.newArrayList(new Spitter("fx", "12343", "fengxuan", "fengxuan@qq.com", true)));
        System.out.println("======" + JSON.toJSONString(spitterMapper.getAll()));
//        throw new IllegalArgumentException("");
    }

    @Transactional(rollbackFor = IllegalArgumentException.class)
    @Override
    public void test2(){
        System.out.println(JSON.toJSONString(spitterMapper.getAll()));
        throw new IllegalArgumentException("");
    }

    @Override
    public void test3() {
        System.out.println("test3:" + JSON.toJSONString(spitterMapper.getAll()));
    }
}
