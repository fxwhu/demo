package com.bmss.test.dubbo.bcsx.testExtend.args;

/**
 * Created by fengxuan1 on 2016/11/17.
 */
public class B1 extends A1 {
    public B1(int i) {
        super(i);
        System.out.println("B1 is called: " + i);
    }
}
