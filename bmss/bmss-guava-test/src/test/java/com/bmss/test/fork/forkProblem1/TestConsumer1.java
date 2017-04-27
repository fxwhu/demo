package com.bmss.test.fork.forkProblem1;

/**
 * Created by fengxuan1 on 2017/4/25.
 */
public class TestConsumer1 {

    public static void main(String[] args) {
        Philosopher1 philosopher = new Philosopher1(new Fork1(), new Fork1());
        philosopher.start();
    }
}
