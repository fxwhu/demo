package com.bmss.test.web;

import com.alibaba.fastjson.JSON;
import com.bmss.test.exception.WebException;
import com.bmss.test.result.WebResult;
import com.bmss.test.vo.ClassInfo;
import com.bmss.test.vo.User;
import group.First;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by fengxuan1 on 2017/3/24.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/login")
    @ResponseBody
    public WebResult login(@Validated(First.class) User user, BindingResult result, @Valid ClassInfo classInfo, BindingResult result1, HttpServletRequest request, HttpServletResponse response){
        WebResult loginResult = null;
        try {
            handleError(result);
            handleError(result1);
            Cookie cookie = new Cookie("name", user.getName());
            cookie.setPath("/");
            response.addCookie(cookie);
            HttpSession session = request.getSession();
            session.setAttribute("user", JSON.toJSONString(user));
            String sessionId = session.getId();
            if(session.isNew()){
                System.out.println("new session" + sessionId);
            }else {
                System.out.println("");
            }
            loginResult = WebResult.SUCCESS;
        } catch (WebException e) {
            e.printStackTrace();
            loginResult = new WebResult(e.getCode(), e.getMsg());
        }
        return loginResult;
    }



    public void handleError(BindingResult result) throws WebException {
        if (result.hasErrors()) {
            String msg = null;
            List<ObjectError> allErrors = result.getAllErrors();
            for (ObjectError objectError : allErrors) {
                String objectName = objectError.getObjectName();
                String defaultMessage = objectError.getDefaultMessage();
                if (msg != null) {
                    msg = msg + ", " + objectName + ": " + defaultMessage;
                } else {
                    msg = objectName + ": " + defaultMessage;
                }
            }
            throw new WebException("000001", msg);
        }
    }
}
