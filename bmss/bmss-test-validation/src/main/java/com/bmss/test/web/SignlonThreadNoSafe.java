package com.bmss.test.web;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by fengxuan1 on 2017/3/29.
 */
@Controller
@Scope("prototype")
public class SignlonThreadNoSafe {

    private int i = 0;

    @RequestMapping("/test/add")
    @ResponseBody
    public int add(){
        i = i + 1;
        return i;
    }
}
