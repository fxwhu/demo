package com.bmss.test.dubbo.bcsx.testfinalize;

/**
 * Created by fengxuan1 on 2016/11/16.
 */
public class Book1 {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("触发finalize");
    }
}
