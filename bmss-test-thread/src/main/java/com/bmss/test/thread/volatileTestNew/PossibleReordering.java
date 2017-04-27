package com.bmss.test.thread.volatileTestNew;

/**
 * Created by fengxuan1 on 2017/2/21.
 */
public class PossibleReordering {

    int x = 0, y = 0;
    int a = 0, b = 0;


    public static void main(String[] args) throws InterruptedException {

    }


    public void test() throws InterruptedException{
        Thread one = new Thread(new Runnable() {
            public void run() {
                a = 1;
                    /*try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                x = b;
            }
        });

        Thread other = new Thread(new Runnable() {
            public void run() {
                b = 1;
                    /*try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                y = a;
            }
        });
        one.start();
        other.start();
        one.join();
        other.join();
        System.out.println("(" + x + "," + y + ")");
//        int x = 0, y=0, a = 0, b = 0;
    }
}
