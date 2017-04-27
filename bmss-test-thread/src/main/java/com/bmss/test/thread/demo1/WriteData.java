package com.bmss.test.thread.demo1;

import java.io.IOException;
import java.io.PipedOutputStream;

/**
 * Created by fengxuan1 on 2017/1/2.
 */
public class WriteData {

    public void writeMethod(PipedOutputStream pipedOutputStream){
        try {
            System.out.println("write :");
            for (int i = 0; i < 300; i++) {
                String outData = "" + (i + 1);
                pipedOutputStream.write(outData.getBytes());
                System.out.print(outData);
            }
            System.out.println();
            pipedOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
