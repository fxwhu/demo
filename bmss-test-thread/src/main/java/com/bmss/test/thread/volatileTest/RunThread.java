package com.bmss.test.thread.volatileTest;

/**
 * Created by fengxuan1 on 2016/12/29.
 */
public class RunThread extends Thread {
    volatile private boolean runFlag = true;

    public boolean isRunFlag() {
        return runFlag;
    }

    public void setRunFlag(boolean runFlag) {
        this.runFlag = runFlag;
    }

    @Override
    public void run() {
        while (runFlag){
//            System.out.println("running .....");
        }
        System.out.println("out !");
    }
}
