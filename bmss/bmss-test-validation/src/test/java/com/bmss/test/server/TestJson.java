package com.bmss.test.server;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bmss.test.vo.User;
import org.junit.Test;

/**
 * Created by fengxuan1 on 2017/3/29.
 */
public class TestJson {

    @Test
    public void jsonToObject(){
        User user = new User();
        user.setName("fx");
        user.setAge(10);
        String s = JSON.toJSONString(user);
        JSONObject jsonObject = JSON.parseObject(s);
        User user1 = jsonObject.toJavaObject(User.class);
        System.out.println();
    }
}
