package someDemo.innerclasses.destination;

import someDemo.innerclasses.Destination;

/**
 * Created by fengxuan1 on 2016/11/20.
 */
public class Outer2 {

    private class DestinationImpl implements Destination {

        @Override
        public void test() {
            System.out.println("DestinationImpl begin");
        }
    }


    public Destination destination(){
        return new DestinationImpl();
    }

}
