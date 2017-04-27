package com.bmss.test.thread.synchron;

/**
 * Created by fengxuan1 on 2016/12/29.
 */
public class Service {
    synchronized public void test(){
        if(Thread.currentThread().getName().equals("a")){
            System.out.println(Thread.currentThread().getName() + "into this method");
            Integer.parseInt("a");
        }else {
            System.out.println(Thread.currentThread().getName() + "into this method");
        }
    }
}
