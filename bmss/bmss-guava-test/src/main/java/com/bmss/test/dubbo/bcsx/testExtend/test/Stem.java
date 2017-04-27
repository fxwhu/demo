package com.bmss.test.dubbo.bcsx.testExtend.test;

/**
 * Created by fengxuan1 on 2016/11/17.
 */
public class Stem extends Root{
    public Stem() {
        System.out.println("Stem is called");
        f1();
    }

    public static void main(String[] args) {
        Stem stem = new Stem();
    }
}
