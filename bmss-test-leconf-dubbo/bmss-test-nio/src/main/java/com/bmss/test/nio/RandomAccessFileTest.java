package com.bmss.test.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by fengxuan1 on 2017/3/17.
 */
public class RandomAccessFileTest {

    public static void main(String[] args) throws IOException {
        RandomAccessFile accessFile = new RandomAccessFile("D:\\test.txt", "rw");

        FileChannel inchannle = accessFile.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(48);

        int read = inchannle.read(buffer);

        while (read != -1){
            System.out.println("READ: " + read);

            buffer.flip();

            while (buffer.hasRemaining()){
                System.out.println((char)buffer.get());
            }

            buffer.clear();

            read = inchannle.read(buffer);

        }

        accessFile.close();
    }
}
