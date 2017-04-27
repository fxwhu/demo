package com.bmss.test.server;

import com.bmss.test.vo.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by fengxuan1 on 2017/3/28.
 */
public class UserService1Test {

    ClassPathXmlApplicationContext context;
    UserService1 userService1;

    @Before
    public void init(){
        context = new ClassPathXmlApplicationContext("classpath:spring/application-web-context.xml");
        userService1 = context.getBean(UserService1.class);
    }

    @Test
    public void test1(){
        User user = new User();
        user.setName("fx");
        userService1.test(user);
    }

}