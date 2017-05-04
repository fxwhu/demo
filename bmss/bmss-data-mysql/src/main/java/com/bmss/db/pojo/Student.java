package com.bmss.db.pojo;

public class Student {
    private Long id;

    private String name;

    private Sex sex;

    private Integer age;

    private String no;

    public Student() {
    }

    public Student(String name, Sex sex, Integer age, String no) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.no = no;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
}