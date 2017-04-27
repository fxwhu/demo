package com.bmss.test.dubbo.bcsx.testInit.staticBlock;

/**
 * Created by fengxuan1 on 2016/11/16.
 */
public class Cups {
    static Cup cup1;
    static Cup cup2;
    static {
        cup1 = new Cup(1);
        cup2 = new Cup(2);
    }

    public Cups() {
        System.out.println("cups init");
    }
}
