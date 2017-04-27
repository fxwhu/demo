package com.bmss.test.dubbo.bcsx.testfinalize;

/**
 * Created by fengxuan1 on 2016/11/16.
 */
public class TerminationCondition {
    public static void main(String[] args) {
        /*Book novel = new Book(true);
        novel.checkIn();
        new Book(true);
        System.gc();*/
        Book1 book1 = new Book1();
        book1 = null;
        System.gc();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("===========");
        }
    }
}
