package com.bmss.testString;

/**
 * Created by fengxuan1 on 2016/12/29.
 */
public class TestString {

    public static void main(String[] args) {
        try {
            test();
        } catch (ArithmeticException e) {
            System.out.println("=========");
            e.printStackTrace();
        }
    }


    public static void test(){
        try {
            int m = 10 / 0;
        } catch (Exception e) {
            throw e;
        }


    }
}
