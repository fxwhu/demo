package com.bmss.test.dubbo.bcsx.testfinalize;

/**
 * Created by fengxuan1 on 2016/11/16.
 */
public class Book {
    boolean checkOut = false;

    public Book(Boolean checkOut) {
        this.checkOut = checkOut;
    }

    void checkIn(){
        checkOut = true;
    }

    protected void finalize(){
        if(checkOut)
            System.out.println("error: check out");
    }
}
