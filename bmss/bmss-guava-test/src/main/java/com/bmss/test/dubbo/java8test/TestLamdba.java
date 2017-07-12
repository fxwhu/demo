package com.bmss.test.dubbo.java8test;


import java.util.Arrays;

/**
 * Created by fengxuan1 on 2016/11/16.
 */
public class TestLamdba {
    public static void main(String[] args) {
        Arrays.asList("a", "b", "c").forEach(e -> System.out.println(e) );
        System.out.println("=========");


        System.out.println();
    }
}
