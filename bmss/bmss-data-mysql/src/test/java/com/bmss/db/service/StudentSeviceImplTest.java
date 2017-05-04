package com.bmss.db.service;

import com.bmss.db.pojo.Sex;
import com.bmss.db.pojo.Student;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by fengxuan1 on 2017/5/3.
 */
public class StudentSeviceImplTest {


    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:springMybatis/spring-jdbc.xml");
        StudentSeviceImpl studentSevice = context.getBean(StudentSeviceImpl.class);
//        StudentThread studentThread1 = new StudentThread(studentSevice, "hong", "-thread1", null);
//        StudentThread studentThread2 = new StudentThread(studentSevice, "hong", "-thread2", null);


        Student student = new Student(null, Sex.male, 14, "00005");
        StudentThread studentThread1 = new StudentThread(studentSevice, null, null, student);
        StudentThread studentThread2 = new StudentThread(studentSevice, null, null, student);
        studentThread1.start();
        Thread.sleep(500);
        studentThread2.start();


        studentThread1.join();
        studentThread2.join();


        System.out.println("====end=====");

    }

}

class StudentThread extends Thread{

    StudentSeviceImpl studentSevice;

    String name, lastName;

    Student student;

    public StudentThread(StudentSeviceImpl studentSevice, String name, String lastName, Student student) {
        this.studentSevice = studentSevice;
        this.name = name;
        this.lastName = lastName;
        this.student = student;
    }

    @Override
    public void run() {
        try {
            studentSevice.selectAndInsert(student);
        } catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
        }
    }
}