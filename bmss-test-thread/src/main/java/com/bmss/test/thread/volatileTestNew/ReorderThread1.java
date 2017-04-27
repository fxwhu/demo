package com.bmss.test.thread.volatileTestNew;

/**
 * Created by fengxuan1 on 2017/2/21.
 */
public class ReorderThread1 extends Thread{

    ReorderExample reorderExample;

    public ReorderThread1(ReorderExample reorderExample) {
        this.reorderExample = reorderExample;
    }

    @Override
    public void run() {
        reorderExample.write();
    }
}
