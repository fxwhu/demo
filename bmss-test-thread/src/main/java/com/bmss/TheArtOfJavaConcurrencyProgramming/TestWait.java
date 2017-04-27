package com.bmss.TheArtOfJavaConcurrencyProgramming;

/**
 * Created by fengxuan1 on 2017/2/24.
 */
public class TestWait {

    private static Integer i = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (i){
                    System.out.println("in thread 1 ");
                    try {
                        i.wait(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i = i + 1;
                    System.out.println("out thread 1 " + i);
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized ((Object) i){
//                    i.notify();
                    System.out.println("in thread 2 ");
                    i = i + 1;
                    System.out.println("out thread 2 " + i);
                }
            }
        });

        thread1.start();
        Thread.sleep(1000);

        thread2.start();
        thread1.join();
        thread2.join();
        /*try {
            Thread.currentThread().wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("======");
        }*/
    }
}
