package com.bmss;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;

/**
 * Created by fengxuan1 on 2017/3/23.
 */
public class TestFastJson {

    @Test
    public void parse(){
        String s = "{\"name\":{\"ha\":\"123\"}}";
        JSONObject jsonObject = JSON.parseObject(s);
        /*String name = (String) jsonObject.get("name");
        JSONObject jsonObject1 = JSON.parseObject(name);*/
        JSONObject jsonObject1 = jsonObject.getJSONObject("name");
        String ha = (String) jsonObject1.get("ha");
        System.out.println(ha);
    }

    @Test
    public void jsonString(){
        Map<String, Object> jsonMap = Maps.newHashMap();
        Map<String, Object> jsonMap1 = Maps.newHashMap();
        jsonMap1.put("ha", "123");
        jsonMap.put("name", jsonMap1);
        String jsonString = JSON.toJSONString(jsonMap);
        System.out.println(jsonString);
    }
}
