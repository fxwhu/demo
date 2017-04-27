package com.bmss.test.dubbo.degsignModel.strategy;

/**
 * Created by fengxuan1 on 2016/10/21.
 */
public class ModelDuck1 extends Duck {

    public ModelDuck1() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new MuteQuack();
    }

    @Override
    public void display() {
        System.out.println("i am a model duck");
    }


    public static void main(String[] args) {
        Duck modelDuck1 = new ModelDuck1();
        modelDuck1.setQuackBehavior(new Quack());
        modelDuck1.display();
        modelDuck1.performFly();
        modelDuck1.performQuack();
    }
}
