package com.bmss.test.thread.demo1;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Created by fengxuan1 on 2017/1/2.
 */
public class Test {

    public static void main(String[] args) {
        try {
            PipedInputStream pipedInputStream = new PipedInputStream();
            PipedOutputStream pipedOutputStream = new PipedOutputStream();

            WriteData writeData = new WriteData();
            ReadData readData = new ReadData();

            pipedInputStream.connect(pipedOutputStream);


            ThreadRead threadRead = new ThreadRead(readData, pipedInputStream);

            ThreadWrite threadWrite = new ThreadWrite(writeData, pipedOutputStream);

            threadRead.start();

            Thread.sleep(1000);

            threadWrite.start();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
