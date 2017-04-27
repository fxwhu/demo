package com.bmss.respository;

import com.alibaba.fastjson.JSON;
import com.bmss.entiy.Student;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Example;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by fengxuan1 on 2017/4/26.
 */
public class StudentRespositoryTest {

    ClassPathXmlApplicationContext context;

    StudentRespository studentRespository;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("classpath:applicationContext-mongo.xml");
        studentRespository = context.getBean(StudentRespository.class);
    }

    @Test
    public void findLikeName() throws Exception {
        List<Student> students = studentRespository.findByNameLike("min");
        System.out.println(JSON.toJSONString(students));
    }

    @Test
    public void findByCreateTimeLessThan(){
        String createTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        List<Student> students = studentRespository.findByCreateTimeLessThan(createTime);
        System.out.println(JSON.toJSONString(students));
    }

    @Test
    public void findByStudent(){
        Student student = new Student();
        student.setName("ming");
        Example<Student> example = Example.of(student);
        List<Student> students = studentRespository.findAll(example);
        System.out.println(JSON.toJSONString(students));
    }

}