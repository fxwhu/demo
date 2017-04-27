package com.bmss.test.web.multipleSession;

import com.bmss.test.vo.MultiUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by fengxuan1 on 2017/3/29.
 */
@Controller
@RequestMapping("/multi")
public class LoginController {

    @RequestMapping("/login")
    @ResponseBody
    public String login(@Valid MultiUser user, HttpServletRequest request){
        request.getSession().setAttribute("username", user.getName());
        return "login success";
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test(HttpServletRequest request){
        Object username = request.getSession().getAttribute("username");
        return (String) username;
    }
}
