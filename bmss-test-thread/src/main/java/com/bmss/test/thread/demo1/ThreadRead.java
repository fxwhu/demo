package com.bmss.test.thread.demo1;

import java.io.PipedInputStream;

/**
 * Created by fengxuan1 on 2017/1/2.
 */
public class ThreadRead extends Thread{

    private ReadData readData;

    private PipedInputStream pipedInputStream;

    public ThreadRead(ReadData readData, PipedInputStream pipedInputStream) {
        this.readData = readData;
        this.pipedInputStream = pipedInputStream;
    }

    @Override
    public void run() {
        readData.readMethod(pipedInputStream);
    }
}
