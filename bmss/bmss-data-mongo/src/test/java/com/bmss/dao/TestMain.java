package com.bmss.dao;

import com.alibaba.fastjson.JSON;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by fengxuan1 on 2017/4/26.
 */
public class TestMain {

    ClassPathXmlApplicationContext context;

    @Before
    public void init(){
        context = new ClassPathXmlApplicationContext("classpath:applicationContext-mongo.xml");
        String[] beans = context.getBeanDefinitionNames();
        System.out.println(JSON.toJSONString(beans));
    }

    @Test
    public void testPrintClientInfo(){
        Object mongo = context.getBean("mongo");
        System.out.println("====");
    }

    @Test
    public void testOtherInfo(){
        MongoClient client = context.getBean(MongoClient.class);
        List<MongoCredential> credentialsList = client.getCredentialsList();
        System.out.println(JSON.toJSONString(credentialsList));
    }
}
