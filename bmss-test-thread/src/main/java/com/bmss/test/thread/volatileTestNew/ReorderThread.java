package com.bmss.test.thread.volatileTestNew;

/**
 * Created by fengxuan1 on 2017/2/21.
 */
public class ReorderThread extends Thread{

    ReorderExample reorderExample;

    public ReorderThread(ReorderExample reorderExample) {
        this.reorderExample = reorderExample;
    }

    @Override
    public void run() {
        reorderExample.read();
    }
}
