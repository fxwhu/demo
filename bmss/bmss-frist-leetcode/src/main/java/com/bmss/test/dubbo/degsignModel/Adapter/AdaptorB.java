package com.bmss.test.dubbo.degsignModel.Adapter;

/**
 * Created by fengxuan1 on 2016/10/26.
 */
public class AdaptorB implements  B{
    private  A a;

    public AdaptorB(A a) {
        this.a = a;
    }

    @Override
    public void test() {
        a.say();
    }


    public static void main(String[] args) {
        A a = new AImpl();
        AdaptorB adaptorB = new AdaptorB(a);
        adaptorB.test();
    }
}
