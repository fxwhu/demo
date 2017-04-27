package com.bmss.entiy;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by fengxuan1 on 2017/4/26.
 */
@Document(collection ="student")
public class Student {

    @Id
//    @Indexed(unique=true)
    private String studentNo;

    private String name, sex, createTime, updateTime;

    private Integer age;

    public Student() {
    }

    public Student(String studentNo, String name, String sex, String createTime, String updateTime, Integer age) {
        this.studentNo = studentNo;
        this.name = name;
        this.sex = sex;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.age = age;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
