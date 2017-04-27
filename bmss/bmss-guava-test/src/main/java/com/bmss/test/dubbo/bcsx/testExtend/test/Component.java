package com.bmss.test.dubbo.bcsx.testExtend.test;

/**
 * Created by fengxuan1 on 2016/11/17.
 */
public class Component {
    public Component() {
        System.out.println("component is called");
    }

    protected void f1(){
        System.out.println("f1");
    }

    private void f2(){
        System.out.println("f2");
    }
}
