package com.bmss.test.dubbo.bcsx.testExtend.test;

/**
 * Created by fengxuan1 on 2016/11/17.
 */
public class Root {
    private Component component1, component2, component3;
    {
        component1 = new Component();
        component2 = new Component();
        component3 = new Component();
    }

    public Root() {
        System.out.println("Root is called");
        component1.f1();//protect 同包下能调用，private不能
    }

    protected void f1(){
        System.out.println("Root f1");
    }
    private void f2(){
        System.out.println("Root f2");
    }
}
