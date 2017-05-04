package com.bmss.db.mapper;

import com.alibaba.fastjson.JSON;
import com.bmss.db.pojo.Sex;
import com.bmss.db.pojo.Student;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by fengxuan1 on 2017/5/2.
 */
public class StudentMapperTest {

    ApplicationContext context;

    StudentMapper studentMapper;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("classpath:springMybatis/spring-jdbc.xml");
        studentMapper = context.getBean(StudentMapper.class);
    }

    @Test
    public void deleteByPrimaryKey() throws Exception {

    }

    @Test
    public void insert() throws Exception {
        Student student = new Student("ming", Sex.male, 10, "00001");
        studentMapper.insert(student);
//        Student student1 = new Student("hong", Sex.FAMALE, 9, "00002");
//        studentMapper.insert(student1);
    }

    @Test
    public void insertSelective() throws Exception {

    }

    @Test
    public void selectByPrimaryKey() throws Exception {
        Student student = studentMapper.selectByPrimaryKey(28L);
        Sex sex = student.getSex();
        System.out.println(sex.getId());
        System.out.println(JSON.toJSONString(student));
//        Student student1 = studentMapper.selectByPrimaryKey(17L);
//        System.out.println(JSON.toJSONString(student1));

    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {

    }

    @Test
    public void updateByPrimaryKey() throws Exception {

    }

}