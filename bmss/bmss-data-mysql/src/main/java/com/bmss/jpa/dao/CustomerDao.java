package com.bmss.jpa.dao;

import com.alibaba.fastjson.JSON;
import com.bmss.jpa.entity.Customer;
import com.bmss.jpa.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fengxuan1 on 2017/3/30.
 */
@Service
public class CustomerDao {

    @Autowired
    CustomerRepository customerRepository;

    public void saveBach(List<Customer> customerList){
        Iterable<Customer> customers = customerRepository.save(customerList);
        for(Customer customer : customers){
            System.out.println("==" + JSON.toJSONString(customer));
        }
    }

    public void findById(Long id){
        Customer customer = customerRepository.findOne(id);
        System.out.println(JSON.toJSONString(customer));
    }
}
