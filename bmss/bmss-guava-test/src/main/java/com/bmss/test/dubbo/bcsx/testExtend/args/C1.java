package com.bmss.test.dubbo.bcsx.testExtend.args;

/**
 * Created by fengxuan1 on 2016/11/17.
 */
public class C1 extends B1 {
    public C1(int i) {
        super(i);
        System.out.println("C1 is called");
    }

    public static void main(String[] args) {
        C1 c1 = new C1(1);
    }
}
