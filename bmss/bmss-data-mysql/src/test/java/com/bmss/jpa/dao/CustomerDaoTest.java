package com.bmss.jpa.dao;

import com.bmss.jpa.entity.Customer;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by fengxuan1 on 2017/3/30.
 */
public class CustomerDaoTest {
    ClassPathXmlApplicationContext context;
    CustomerDao customerDao;
    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("classpath:propertiesTest/spring-jdbc.xml");
        customerDao = context.getBean(CustomerDao.class);

    }

    @Test
    public void saveBach() throws Exception {
        Customer customer = new Customer();
        customer.setFirstName("ming");
        customer.setLastName("xiao");
        customer.setEmailAddress("xiaoming@qq.com");

        Customer customer1 = new Customer();
        customer1.setFirstName("hong");
        customer1.setLastName("xiao");
        customer1.setEmailAddress("xiaohong@qq.com");

        List<Customer> customers = Lists.newArrayList(customer, customer1);
        customerDao.saveBach(customers);
    }

    @Test
    public void findById() throws Exception {
    }

}