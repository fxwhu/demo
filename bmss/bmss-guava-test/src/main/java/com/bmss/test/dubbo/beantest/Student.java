package com.bmss.test.dubbo.beantest;

/**
 * Created by fengxuan1 on 2017/4/24.
 */
public class Student {

    private String name, sex, studentNo;

    private int age;

    private Address address;

    public Student() {
    }

    public Student(String name, String sex, String studentNo, int age, Address address) {
        this.name = name;
        this.sex = sex;
        this.studentNo = studentNo;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }
}
