package someDemo.innerclasses.staticInner;

import someDemo.innerclasses.Destination;

/**
 * Created by fengxuan1 on 2016/11/20.
 */
public interface Service {

    void test();

    class DestinationImpl implements Destination {

        @Override
        public void test() {
            System.out.println("test");
        }
    }
}
