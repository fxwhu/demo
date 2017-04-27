package com.bmss.xa.service;

import com.bmss.xa.mapper1.Db1TraceMapper;
import com.bmss.xa.mapper2.Db2TraceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by fengxuan1 on 2017/4/14.
 */
@Component
public class TraceService {

    @Autowired
    Db1TraceMapper db1TraceMapper;

    @Autowired
    Db2TraceMapper db2TraceMapper;

    @Transactional
    public void updateMultipleDateSource(String inuserId, String deuserId, long money) throws InterruptedException {
        int deLine = db1TraceMapper.decreaseMoney(deuserId, 1);
        if(deLine != 1){
            throw new IllegalArgumentException(deuserId + "账户的钱小于" + money);
        }
        //todo something cost much time
//        Thread.sleep(1000 * 60);
        int inLine = db2TraceMapper.increaseMoney(inuserId, 1);
        throw new IllegalArgumentException("测试");
    }


    @Transactional
    public void testTransactional(String userId){
        int i = db1TraceMapper.decreaseMoney(userId, 1);
        System.out.println("=-=" + i );
//        throw new IllegalArgumentException("测试");
    }
}
