package com.bmss.test.dubbo.bcsx.testExtend.moliComment;

import com.bmss.test.dubbo.bcsx.testExtend.moliComment.impl.ADaoImpl;

/**
 * Created by fengxuan1 on 2016/11/17.
 */
public class AService {
    private ADao aDao = new ADaoImpl();
    public void test(){
        aDao.getBasic().method1();
    }

    public static void main(String[] args) {
        AService aService = new AService();
        aService.test();
    }
}
