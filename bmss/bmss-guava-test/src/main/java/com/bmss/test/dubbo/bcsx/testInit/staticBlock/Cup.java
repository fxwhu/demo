package com.bmss.test.dubbo.bcsx.testInit.staticBlock;

/**
 * Created by fengxuan1 on 2016/11/16.
 */
public class Cup {

    public Cup(int i) {
        System.out.println("init cup: " + i);
    }


    void f1(){
        System.out.println("call cup f1()");
    }
}
