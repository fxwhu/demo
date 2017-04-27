package com.bmss.dao;

import com.alibaba.fastjson.JSON;
import com.bmss.entiy.Student;
import com.bmss.respository.StudentRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by fengxuan1 on 2017/4/26.
 */
@Component
public class StudentDao {

    private static Logger logger = LoggerFactory.getLogger(StudentDao.class);

    @Autowired
    StudentRespository studentRespository;

    public void insert(Student student){
        Student insert = studentRespository.insert(student);
        logger.info(JSON.toJSONString(insert));

    }


    public void get(){
        Pageable pageable = new PageRequest(0, 10);
        pageable.getSort().getOrderFor("creatTime");
        Page<Student> all = studentRespository.findAll(pageable);
        logger.info(JSON.toJSONString(all));
    }


    public void findByNameAndAge(String name, int age){
        List<Student> byNameAndAge = studentRespository.findByNameAndAge(name, age);
        logger.info(JSON.toJSONString(byNameAndAge));
    }
}
