package com.bmss.config;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by fengxuan1 on 2017/4/13.
 */
@Component
public class UserDao {

    @Autowired
    User user;
    public void print(){
        System.out.println(JSON.toJSONString(user));
    }
}
