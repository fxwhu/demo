package com.bmss.test.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by fengxuan1 on 2016/12/26.
 */
@Controller
public class Hello {

    private static Logger logger = LoggerFactory.getLogger(Hello.class);

    @RequestMapping("/hello")
    @ResponseBody
    public String testHello(){
        logger.info("info message");
        logger.debug("debug message");
        return "hello";
    }
}
