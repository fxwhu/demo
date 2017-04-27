package com.bmss.test.server;

import com.bmss.test.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;


/**
 * Created by fengxuan1 on 20173/28.
 */
@Service
public class UserService1 {

    @Autowired
    private Validator validator;

    public User test(User name){
        Set<ConstraintViolation<User>> validate = validator.validate(name/*, First.class*/);
        boolean empty = validate.isEmpty();
        if(!empty){
            System.out.println("error");
        }
        System.out.println("=====");
        return null;
    }


    public static void main(String[] args) {
        UserService1 userService1 = new UserService1();
        User user = new User();
//        user.setName("fx");
        userService1.test(null);
    }
}
