package com.bmss.session.multipleSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by fengxuan1 on 2017/3/29.
 */
@Controller
@RequestMapping("/multi")
public class LoginController {

    @RequestMapping("/login")
    @ResponseBody
    public String login(MultiUser user, HttpServletRequest request){
        /*HttpSession session = request.getSession();
        session.setAttribute("username", user.getName());*/
        return "login success";
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test(HttpServletRequest request){
        Object username = request.getSession().getAttribute("username");
        return (String) username;
    }
}
