package com.bmss.reflect;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by fengxuan1 on 2017/5/4.
 */
public class ReflectHelloByCGLIB implements MethodInterceptor {

    private Object target;

    public Object bind(Object target){
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("-----cglib代理-----");
        Object result = methodProxy.invokeSuper(o, objects);
        return result;
    }
}
