package com.bmss.xa.service;

import com.bmss.xa.Account;
import com.bmss.xa.mapper1.Db1TraceMapper;
import com.bmss.xa.mapper2.Db2TraceMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by fengxuan1 on 2017/4/14.
 */
public class TraceServiceTest {

    ClassPathXmlApplicationContext context;
    Db1TraceMapper db1TraceMapper;
    Db2TraceMapper db2TraceMapper;
    TraceService traceService;

    @Before
    public void init(){
        context = new ClassPathXmlApplicationContext("classpath:spring/application-mysql.xml");
        db1TraceMapper = context.getBean(Db1TraceMapper.class);
        db2TraceMapper = context.getBean(Db2TraceMapper.class);
        traceService = context.getBean(TraceService.class);
    }

    @Test
    public void testDb1(){
        int hong = db1TraceMapper.insert(new Account("hong", 10));
        System.out.println(hong);
    }

    @Test
    public void testDb2(){
        int hong = db2TraceMapper.insert(new Account("ming", 10));
        System.out.println(hong);
    }

    @Test
    public void testTransactional(){
        traceService.testTransactional("hong");
    }

    @Test
    public void testXA(){
        try {
            traceService.updateMultipleDateSource("ming", "hong", 1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception exception){
            System.out.println(exception.fillInStackTrace());
        }
    }
}