package com.bmss.reflect;

/**
 * Created by fengxuan1 on 2017/5/4.
 */
public class TestMain {

    public static void main(String[] args) {
        ReflectHelloByJDk reflectHelloByJDk = new ReflectHelloByJDk();
        HelloService helloService = (HelloService)reflectHelloByJDk.bind(new HelloSeviceImpl());
        helloService.sayHello("jdk");



        ReflectHelloByCGLIB reflectHelloByCGLIB = new ReflectHelloByCGLIB();
        HelloService helloService1 = (HelloService) reflectHelloByCGLIB.bind(new HelloSeviceImpl());
        helloService1.sayHello("cglib");
    }
}
