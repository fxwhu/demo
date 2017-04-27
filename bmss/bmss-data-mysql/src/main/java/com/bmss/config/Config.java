package com.bmss.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by fengxuan1 on 2017/4/13.
 */
@Configuration
public class Config {
    @Bean
    public User getUser(){
        User user = new User();
        user.setName("xiao");
        user.setAge(10);
        return user;
    }

}
