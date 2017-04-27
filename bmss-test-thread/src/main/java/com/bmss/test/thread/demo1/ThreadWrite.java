package com.bmss.test.thread.demo1;

import java.io.PipedOutputStream;

/**
 * Created by fengxuan1 on 2017/1/2.
 */
public class ThreadWrite extends Thread{

    private WriteData writeData;

    private PipedOutputStream pipedOutputStream;

    public ThreadWrite(WriteData writeData, PipedOutputStream pipedOutputStream) {
        this.writeData = writeData;
        this.pipedOutputStream = pipedOutputStream;
    }

    @Override
    public void run() {
        writeData.writeMethod(pipedOutputStream);
    }
}
