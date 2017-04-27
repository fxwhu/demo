package com.bmss.xa;

import java.util.List;

/**
 * Created by fengxuan1 on 2017/4/21.
 */
public class People {
    private String name;

    private int age;

    private List<String> phoneNum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(List<String> phoneNum) {
        this.phoneNum = phoneNum;
    }
}
