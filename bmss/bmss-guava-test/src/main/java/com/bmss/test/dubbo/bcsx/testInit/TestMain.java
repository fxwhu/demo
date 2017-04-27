package com.bmss.test.dubbo.bcsx.testInit;

/**
 * Created by fengxuan1 on 2016/11/16.
 */
public class TestMain {
    static A a1 = new A();

    public static void main(String[] args) {
        System.out.println("===1===");
        a1.f1();
        A.bowl1 = null;
        a1 = null;
        System.gc();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("=====2=====");
        A a = new A();
        a.f1();
    }
}
