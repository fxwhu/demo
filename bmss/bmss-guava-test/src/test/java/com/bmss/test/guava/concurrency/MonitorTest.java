package com.bmss.test.guava.concurrency;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by fengxuan1 on 2017/4/25.
 */
public class MonitorTest {

    private static Logger logger = LoggerFactory.getLogger(MonitorTest.class);

    public static void main(String[] args) throws InterruptedException {
        MonitorService monitorService = new MonitorService();



        List<Thread> threads = Lists.newArrayList();

        for (int i = 0; i < 10; i++) {
            ThreadGet threadGet = new ThreadGet(monitorService);
            ThreadSet threadSet = new ThreadSet(i, monitorService);
            threads.add(threadGet);
            threads.add(threadSet);
        }


        for (Thread thread: threads) {
            thread.start();
        }

        for (Thread thread: threads) {
            thread.join();
        }

        System.out.println("end");


    }


}
