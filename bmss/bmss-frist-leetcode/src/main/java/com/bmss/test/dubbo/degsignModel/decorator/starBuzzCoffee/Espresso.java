package com.bmss.test.dubbo.degsignModel.decorator.starBuzzCoffee;

/**
 * Created by fengxuan1 on 2016/10/21.
 */
public class Espresso extends Beverage {

    public Espresso() {
        this.description = "Espresso coffee";
    }

    @Override
    public double count() {
        return .79;
    }
}
