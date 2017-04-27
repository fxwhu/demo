package com.bmss.test.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by fengxuan1 on 2016/12/27.
 */
public class TestException {

    private static Logger logger = LoggerFactory.getLogger(TestException.class);


    public static void test(String a){
        if(a.equals("a"))
            throw new IllegalArgumentException("参数错误" + a);
        Integer.parseInt(a);
        System.out.println("是否继续");
    }


    public static void main(String[] args) {
        try {
            test("b");
        } catch (Exception e) {
            System.out.println(e.getMessage());
//            e.getCause();
//            StringWriter stringWriter = new StringWriter();
            e.printStackTrace();
//            String error = stringWriter.toString();
//            logger.error(error);
            logger.error("fail", e.fillInStackTrace());
        } finally {
            System.out.println("end");
        }
    }
}
