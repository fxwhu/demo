package com.bmss.test.thread.volatileTestNew;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by fengxuan1 on 2017/2/21.
 */
public class Counter {

    private AtomicInteger atomicInteger = new AtomicInteger();

    static volatile int i = 0;

    public static void main(String[] args) {
        final Counter cas = new Counter();
        List<Thread> threads = Lists.newArrayList();
        long start = System.currentTimeMillis();
        for (int j = 0; j < 10; j++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
//                    synchronized ((Object) i){
                    for (int m = 0; m < 100; m++) {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        cas.safeCount();
                        cas.count();

                        }
//                    }

                }
            });
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(cas.i);
        System.out.println("=======" + cas.atomicInteger.get());
        System.out.println(System.currentTimeMillis() - start);
    }


    private void safeCount(){
        for (;;){
            int i = atomicInteger.get();
            boolean suc = atomicInteger.compareAndSet(i, ++i);
//            System.out.println("suc: " + suc);
            if(suc){
                break;
            }
        }
    }

    synchronized private void count(){
//        System.out.println("i: " + i);
        i++;
    }
}
