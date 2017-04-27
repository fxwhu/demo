package com.bmss.test.dubbo.degsignModel.strategy;

/**
 * Created by fengxuan1 on 2016/10/21.
 */
public class FlyNoWay implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("can not fly");
    }
}
