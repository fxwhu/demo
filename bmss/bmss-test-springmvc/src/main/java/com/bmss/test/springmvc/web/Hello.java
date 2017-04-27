package com.bmss.test.springmvc.web;

import com.bmss.test.springmvc.util.WxUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by fengxuan1 on 2016/10/21.
 */
@Controller
@RequestMapping("/hello")
public class Hello {

    @RequestMapping("/test")
    public String test() {
        return "/hello";
    }


    @RequestMapping("/test1")
    @ResponseBody
    public void test1(String signature, String timestamp, String nonce, String echostr, HttpServletRequest request, HttpServletResponse response) throws IOException, NoSuchAlgorithmException {
        /**
         * 验证接口配置信息
         * 加密/校验流程如下：
         1. 将token、timestamp、nonce三个参数进行字典序排序
         2. 将三个参数字符串拼接成一个字符串进行sha1加密
         3. 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
         */
        String token = "fxwhu";
        boolean flag = WxUtils.checkSingature(signature, token, timestamp, nonce);
        if(flag){
            response.getWriter().print(echostr);
        }
    }

}
