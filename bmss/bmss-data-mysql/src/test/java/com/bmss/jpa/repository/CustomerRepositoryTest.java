package com.bmss.jpa.repository;

import com.alibaba.fastjson.JSON;
import com.bmss.jpa.entity.Customer;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * Created by fengxuan1 on 2017/4/27.
 */
public class CustomerRepositoryTest {
    ClassPathXmlApplicationContext context;
    CustomerRepository customerRepository;
    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("classpath:propertiesTest/spring-jdbc.xml");
        customerRepository = context.getBean(CustomerRepository.class);
    }

    @Test
    public void testFindById(){
        List<Sort.Order> orders = Lists.newArrayList(new Sort.Order(Sort.Direction.DESC, "lastName"));
        Sort sort = new Sort(orders);
        Pageable pageable = new PageRequest(0, 10, sort);
        Page<Customer> customers = customerRepository.findById(1L, pageable);
        System.out.println(JSON.toJSONString(customers));
    }
}