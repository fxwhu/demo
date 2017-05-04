package com.bmss.reflect;

/**
 * Created by fengxuan1 on 2017/5/4.
 */
public class HelloSeviceImpl implements HelloService {
    @Override
    public void sayHello(String message) {
        System.out.println("hello: " + message);
    }
}
