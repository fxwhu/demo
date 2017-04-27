package com.bmss.test.dubbo.service.impl;

import com.bmss.test.dubbo.service.SpitterService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by fengxuan1 on 2016/12/5.
 */
public class SpitterServiceImplTest {

    SpitterService spitterService;

    @Before
    public void setUp() throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-context" +
                ".xml");
        spitterService = context.getBean(SpitterService.class);
    }

    @Test
    public void testTestTransaction() throws Exception {
        try {
            spitterService.testTransaction();
            spitterService.test2();
        } catch (Exception e) {
            spitterService.test3();
        }
    }

    @Test
    public void testTest2() throws Exception {

    }
}