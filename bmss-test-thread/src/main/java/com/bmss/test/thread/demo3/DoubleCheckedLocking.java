package com.bmss.test.thread.demo3;

/**
 * Created by fengxuan1 on 2017/1/3.
 */
public class DoubleCheckedLocking {

    volatile private static DoubleCheckedLocking instance;

    private DoubleCheckedLocking(){

    }

    public DoubleCheckedLocking getInstance(){
        if(instance == null){
            synchronized (DoubleCheckedLocking.class){
                if(instance == null)
                    instance = new DoubleCheckedLocking();
            }
        }
        return instance;
    }
}
