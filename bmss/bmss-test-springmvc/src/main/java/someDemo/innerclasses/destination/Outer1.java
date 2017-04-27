package someDemo.innerclasses.destination;

import someDemo.innerclasses.Destination;

/**
 * Created by fengxuan1 on 2016/11/20.
 */
public class Outer1 {

    public Destination destination(){
        class DestinationImpl implements Destination{
            @Override
            public void test() {
                System.out.println("DestinationImpl begin");
            }
        }
        return new DestinationImpl();
    }

    public static void main(String[] args) {
        Outer1 outer1 = new Outer1();
        Destination destination = outer1.destination();
        destination.test();
    }
}
