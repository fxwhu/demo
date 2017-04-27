package com.bmss.test.thread.volatileTestNew;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by fengxuan1 on 2017/2/21.
 */
public class VolatileTest {

    static volatile boolean flag = true;

    public static void main(String[] args) {

        List<Thread> threads = Lists.newArrayList();

        for (int i = 0; i < 10; i++) {
            final int nums = i;
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    /*synchronized ((Object) flag){
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("=======" + nums);
                    }*/

                    System.out.println("=======" + nums);

                    /*while (flag){
                        flag = false;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("=======" + nums);
                    }
                    flag = true;*/
                    /*if(flag){
                        flag = false;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("=======" + nums);
                        flag = true;
                    }*/
                }
            });
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.start();
        }



    }
}
