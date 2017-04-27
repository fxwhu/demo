package com.bmss.test.dubbo.beantest;

/**
 * Created by fengxuan1 on 2017/4/24.
 */
public class People {

    private String name, sex;

    private Address address;


    public People(String name, String sex, Address address) {
        this.name = name;
        this.sex = sex;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
