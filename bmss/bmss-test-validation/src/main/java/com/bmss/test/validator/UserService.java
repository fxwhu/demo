package com.bmss.test.validator;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;

/**
 * Created by fengxuan1 on 2017/3/28.
 */
public class UserService {

    public void createUser(@Email String email, @NotNull String name){
        System.out.println("hello");
    }

    public static void main(String[] args) {
        UserService service = new UserService();
        service.createUser("test", "fx");
    }
}
