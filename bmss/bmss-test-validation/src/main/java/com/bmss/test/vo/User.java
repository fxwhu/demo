package com.bmss.test.vo;


import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by fengxuan1 on 2017/3/24.
 */
public class User {

    @NotNull/*(groups = First.class)*/
    private String name;

    @Min(value = 10,message = "不得小于十岁")
    private int age;

    @Email/*(groups = Second.class)*/
    private String email;

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

//    @Pattern(regexp = "/^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w{2,3}){1,3})$/",message = "错误邮箱")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
