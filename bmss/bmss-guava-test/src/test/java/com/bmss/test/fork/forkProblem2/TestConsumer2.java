package com.bmss.test.fork.forkProblem2;

/**
 * Created by fengxuan1 on 2017/4/25.
 */
public class TestConsumer2 {

    public static void main(String[] args) throws InterruptedException {
        Fork2 fork2 = new Fork2();
        for (int i = 0; i < 5; i++) {
            Philosopher2 philosopher2 = new Philosopher2(fork2);
            philosopher2.setName(String.valueOf(i));
            philosopher2.start();
        }

        Thread.sleep(2000);

        System.out.println("end");
    }
}
