package com.bmss.test.dubbo.degsignModel.decorator.starBuzzCoffee;

/**
 * Created by fengxuan1 on 2016/10/21.
 */
public class Milk extends CondimentDecorator {
    Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return "MILK" + " ," + beverage.getDescription();
    }

    @Override
    public double count() {
        return 0.45  + beverage.count();
    }
}
