package com.bmss.db.service;

import com.alibaba.fastjson.JSON;
import com.bmss.db.mapper.StudentMapper;
import com.bmss.db.pojo.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by fengxuan1 on 2017/5/3.
 */
@Component
public class StudentSeviceImpl {

    private static Logger logger = LoggerFactory.getLogger(StudentSeviceImpl.class);

    @Autowired
    private StudentMapper studentMapper;

    @Transactional
    public void test1(String name, String lastName) throws InterruptedException {
        Student student = studentMapper.selectByNameAndNo(name, null);
        logger.info(JSON.toJSONString(student));
        Thread.sleep(10000);
        student.setName(lastName);
//        student.setAge(student.getAge() + 1);
        studentMapper.insertAndUpdate(student);
        Student student1 = studentMapper.selectByNameAndNo(lastName, null);
        logger.info(JSON.toJSONString(student1));
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void selectAndInsert(Student student) throws InterruptedException {
//        studentMapper.insert(student);

        Student studentFind = studentMapper.selectByNameAndNo(student.getName(), student.getNo());
        logger.info(JSON.toJSONString(studentFind));

        Thread.sleep(10000 * 60);
//        throw  new RuntimeException("测试事务回滚");

    }




}
