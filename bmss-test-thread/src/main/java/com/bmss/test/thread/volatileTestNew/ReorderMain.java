package com.bmss.test.thread.volatileTestNew;

/**
 * Created by fengxuan1 on 2017/2/21.
 */
public class ReorderMain {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            ReorderExample reorderExample = new ReorderExample();
            reorderExample.test();
        }
    }
}
