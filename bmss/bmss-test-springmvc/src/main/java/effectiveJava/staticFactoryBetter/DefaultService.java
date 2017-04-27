package effectiveJava.staticFactoryBetter;

/**
 * Created by fengxuan1 on 2016/11/20.
 */
public class DefaultService implements Service {

    private DefaultService(){}

    @Override
    public void showSometing() {
        System.out.println("defaultservice");
    }

    public static Provider provider = new Provider() {
        @Override
        public Service newService() {
            return new DefaultService();
        }
    };
}
