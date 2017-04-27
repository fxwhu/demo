package com.bmss.test.dubbo.bcsx.testInit;

/**
 * Created by fengxuan1 on 2016/11/16.
 */
public class Bowl {

    public Bowl(int num) {
        System.out.println("init bowl: " + num);
    }

    public void f1(int num){
        System.out.println("call bowl f1() method: " + num);
    }
}
