package com.bmss.redis.memberPoints;

import com.alibaba.fastjson.JSON;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * Created by fengxuan1 on 2017/4/24.
 */
public class TestMemberPoints {

    ClassPathXmlApplicationContext context;
    RedisTemplate<String, String> redisTemplate;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("classpath:spring/spring-redis.xml");
        redisTemplate = context.getBean(RedisTemplate.class);
    }

    @org.junit.Test
    public void getVaule(){
        Map<Object, Object> entries = redisTemplate.opsForHash().entries("user_signin:months_1000076363");
        System.out.println(JSON.toJSONString(entries));

       /* for (Object mapkey: entries.keySet()) {
            System.out.println("=====" + (String) entries.get(mapkey) + " ,==" + (String)mapkey);
        }*/
    }



    @Test
    public void testUrl(){
        int i = 0;

        for (int j = 0; j < 100; j++) {
            String url = new String("http://c.lenovo.com.cn/comment/getproductcomment/1.do?jsonpcallback=jQuery183007453613613635635_1493020591265&gcode=58519&plat=1&pageSize=10&level=0&lable=&_=1493023263644");
            try {
                getUrlReturn(url);
            } catch (Exception e) {
                i++;
                e.printStackTrace();
            }
        }

        System.out.println("=======" + i);

    }



    @Test
    public void deleteTodayView(){
        Object o = redisTemplate.opsForHash().delete("user_signin:today", "1000076363");
        System.out.println(o);
    }



    public static String getUrlReturn(String url) throws Exception {
        String result = new String();
        URL getUrl = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
        connection.setConnectTimeout(100);
        connection.connect();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        result = reader.readLine();
        reader.close();
        connection.disconnect();
        return result;
    }
}
