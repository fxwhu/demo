package someDemo.innerclasses.staticInner;

/**
 * Created by fengxuan1 on 2016/11/20.
 */
public class ServiceImpl implements Service {
    @Override
    public void test() {

    }

    public static void test1(){
        new DestinationImpl();
    }
}
