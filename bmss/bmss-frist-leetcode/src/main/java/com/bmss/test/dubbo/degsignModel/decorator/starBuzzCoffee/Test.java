package com.bmss.test.dubbo.degsignModel.decorator.starBuzzCoffee;

/**
 * Created by fengxuan1 on 2016/10/21.
 */
public class Test {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        beverage = new Milk(beverage);
        System.out.println(beverage.getDescription());
        System.out.println(beverage.count());
    }
}
