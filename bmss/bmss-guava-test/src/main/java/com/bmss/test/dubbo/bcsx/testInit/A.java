package com.bmss.test.dubbo.bcsx.testInit;

/**
 * Created by fengxuan1 on 2016/11/16.
 */
public class A {
    static Bowl bowl1 = new Bowl(1);
    Bowl bowl2 = new Bowl(2);
    public A() {
        System.out.println("init A");
        bowl3.f1(2);
    }
    public void f1(){
        bowl1.f1(2);
    }
    static Bowl bowl3 = new Bowl(3);


    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalized A");
    }
}
