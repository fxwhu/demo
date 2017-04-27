package com.bmss.test.guava.io;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by fengxuan1 on 2017/4/26.
 */
public class BaseEncodingTest {
    @Test
    public void test() throws IOException {
        File file = new File("D://00000000000000003894.log");

        List<String> strings = Files.readLines(file, Charsets.UTF_8);

        System.out.println(strings);

        /*byte[] bytes = Files.toByteArray(file);

        BaseEncoding baseEncoding = BaseEncoding.base64();

        String encode = baseEncoding.encode(bytes);

        System.out.println(encode);*/
    }
}
