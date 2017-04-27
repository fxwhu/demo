package com.bmss.test.dubbo.degsignModel.decorator.starBuzzCoffee;

/**
 * Created by fengxuan1 on 2016/10/21.
 */
public abstract class Beverage {

    String description = "Unkown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double count();
}
