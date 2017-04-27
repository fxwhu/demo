package com.bmss.test.dubbo.bcsx.testExtend.noargs;

/**
 * Created by fengxuan1 on 2016/11/17.
 */
public class C extends B {
    public C() {
        System.out.println("C is called");
    }

    public static void main(String[] args) {
        C c = new C();
    }
}
