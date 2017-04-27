package com.bmss.test.dubbo.degsignModel.decorator.starBuzzCoffee;

/**
 * Created by fengxuan1 on 2016/10/21.
 */
public class HouseBlend extends Beverage {

    public HouseBlend() {
        this.description = "House Blend coffee";
    }

    @Override
    public double count() {
        return .89;
    }
}
