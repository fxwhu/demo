package com.bmss.dao;

import com.bmss.entiy.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by fengxuan1 on 2017/4/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-mongo.xml"})
public class StudentDaoTest {

    @Autowired
    StudentDao studentDao;

    @Test
    public void insert() throws Exception {

        String createTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String updateTime = createTime;

        Student student = new Student("000001", "ming", "male", createTime, updateTime, 10);
        studentDao.insert(student);
    }

    @Test
    public void findByNameAndAge(){
        studentDao.findByNameAndAge("ming", 10);
    }



}