package com.bmss.test;

/**
 * Created by fengxuan1 on 2017/3/13.
 */
public class TestException {
    public static void main(String[] args) {
        try {
            int i = 100 / 0;
            System.out.println("hello");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
