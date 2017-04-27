package effectiveJava.staticFactoryBetter;

/**
 * Created by fengxuan1 on 2016/11/20.
 */
public class Test {

    public static void main(String[] args) {
        Services.resgisterProvider("service1", Service1.provider);
        Service service1 = Services.newInstance("service1");
        service1.showSometing();
        Service service = Services.newInstance();
        service.showSometing();
    }
}
