package com.bmss.properties;

import com.alibaba.fastjson.JSON;
import com.bmss.xa.Account;
import org.apache.commons.beanutils.PropertyUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by fengxuan1 on 2017/4/20.
 */
public class MyPropertiesTest {

    ClassPathXmlApplicationContext context;

    MyProperties myProperties;

    Account account;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("classpath*:propertiesTest/my-properties.xml");
        myProperties = context.getBean(MyProperties.class);
        account = context.getBean(Account.class);
    }

    @Test
    public void testAccount() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        System.out.println(JSON.toJSONString(account));
        System.out.println(JSON.toJSONString(myProperties.getKeyAndBean()));


        PropertyUtils.setNestedProperty(account, "userId" , "10");



        System.out.println("=======");
        System.out.println(JSON.toJSONString(account));

    }


    public void getField(Object object){
        object.getClass().getDeclaredFields();
    }

}