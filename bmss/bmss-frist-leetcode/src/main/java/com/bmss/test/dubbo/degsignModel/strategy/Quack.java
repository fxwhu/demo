package com.bmss.test.dubbo.degsignModel.strategy;

/**
 * Created by fengxuan1 on 2016/10/21.
 */
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Quack");
    }
}
