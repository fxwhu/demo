package com.bmss.test.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bmss.test.result.WebResult;
import com.bmss.test.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.bmss.test.result.WebResult.SUCCESS;

/**
 * Created by fengxuan1 on 2017/3/24.
 */
@Controller
@RequestMapping("/test")
public class TestUserInfoController {
    @RequestMapping("/getCk")
    @ResponseBody
    public WebResult test(HttpServletRequest request){
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        System.out.println("===");
        User result = new User();
        if(user != null){
            JSONObject jsonObject = JSON.parseObject((String) user);
            result = jsonObject.toJavaObject(User.class);
        }
        WebResult webResult = SUCCESS;
        webResult.setData(result.getName());
        return  webResult;
    }
}
