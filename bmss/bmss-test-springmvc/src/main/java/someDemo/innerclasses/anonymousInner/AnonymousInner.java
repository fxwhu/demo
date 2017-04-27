package someDemo.innerclasses.anonymousInner;

import someDemo.innerclasses.Destination;
import someDemo.innerclasses.Destination1;

/**
 * Created by fengxuan1 on 2016/11/20.
 */
public class AnonymousInner {

    public Destination destination(){
        return new Destination() {
            @Override
            public void test() {
                System.out.println("begin");
            }
        };
    }

    public Destination1 destination1(int i, final int k){
        return new Destination1(i){
            @Override
            public void test() {
                super.test();
            }

            @Override
            public void test1(int j) {
                j = k;
                System.out.println(j);
            }
        };
    }
}
