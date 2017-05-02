package com.bmss.test.dubbo.degsignModel;

/**
 * Created by fengxuan1 on 2016/10/21.
 */
/*
* 1.封装可能变化的部分       开闭原则
* 2.针对接口编程而不是实现   依赖倒转原则
* 3.多用组合，少用继承      合成复用原则
* 4.交互对象尽可能的松耦合  迪米特法则
*
*策略模式：多采用组合而非继承
*
*
*观察者模式：定义了一对多的关系，observer可以随时从subject移除或添加，具体的subject也可能设置和获取状态的方法，
*         数据是由主题提供的，所以观察者是依赖subject的。符合送耦合的思路，设置状态的必要性(如果没有设置状态，
*         subject一旦有变化，就会主动把数据推送过去，可以认为设置状态为一个敏感阈值)，顺序为先判断改变是否达到
*         阈值，达到了就调用setChanged  再调用notifyObservers(Object arg) 具体可以参考 Observable。注意observable
*         的不友好的一面，它是一个具体类而非接口
*
*
* 装饰器模式：
*
*
*
* 单例模式：
*
*
*
*
*
*
* 工厂模式：及其变种 静态工厂方法不能通过继承来改变创建方法的行为
* 简单工厂模式又称为静态工厂方法模板，工厂角色：本模式的核心
* 工厂方法模式是简单工厂模式的进一步抽象化和推广，工厂方法模式里不再只由一个工厂类决定那一个产品类应当被实例化,这个决定被交给抽象工厂的子类去做。
* 工厂方法模式的核心是一个抽象工厂类,而不像简单工厂模式, 把核心放在一个实类上。
* 在抽象工厂模式中，抽象产品 (AbstractProduct) 可能是一个或多个，从而构成一个或多个产品族(Product Family)。 在只有一个产品族的情况下，抽象工厂模式实际上退化到工厂方法模式。
*
*
* 外观模板（集合了一堆子类的实现，简化接口）   适配器模板（将一个接口转化为目标接口的实现，分为类适配器以及对象适配器，
* 其中对象适配器是用的组合的方式而类用的是继承的方式）
*
* 模板方法模式 （抽象类决定了事件的顺序）   策略模板    工厂模板
* */
public class Model1 {
}