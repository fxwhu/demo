package com.bmss.xa;

import com.bmss.config.User;
import com.bmss.config.UserDao;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by fengxuan1 on 2017/4/13.
 */
public class UserTest {
    ClassPathXmlApplicationContext context;
    User user;
    UserDao userDao;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("classpath:spring/application-mysql.xml");
        user = context.getBean(User.class);
        userDao = context.getBean(UserDao.class);
    }

    @Test
    public void test(){
//        System.out.println(JSON.toJSONString(user));
        userDao.print();
    }

}