package com.bmss.test.thread.demo1;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * Created by fengxuan1 on 2017/1/2.
 */
public class ReadData {

    public void readMethod (PipedInputStream pipedInputStream){
        try {
            System.out.println("read :");
            byte[] bytes = new byte[20];
            int read = pipedInputStream.read(bytes);
            while (read != -1){
                String newData = new String(bytes, 0, read);
                System.out.print(newData);
                read = pipedInputStream.read(bytes);
            }
            System.out.println();
            pipedInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
