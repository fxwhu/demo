package effectiveJava.staticFactoryBetter;

/**
 * Created by fengxuan1 on 2016/11/20.
 */
public class Service1 implements Service{
    private Service1(){}

    @Override
    public void showSometing() {
        System.out.println("service1");
    }

    public static Provider provider = new Provider() {
        @Override
        public Service newService() {
            return new Service1();
        }
    };

}
