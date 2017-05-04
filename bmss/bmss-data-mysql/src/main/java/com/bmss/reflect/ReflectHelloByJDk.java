package com.bmss.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by fengxuan1 on 2017/5/4.
 */
public class ReflectHelloByJDk implements InvocationHandler{

    private Object target;

    public Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }




    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("---------jdk 代理-------");
        Object result = null;
        result = method.invoke(target, args);
        return result;
    }
}
