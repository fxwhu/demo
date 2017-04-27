package someDemo.typeinof.reflect.invoke.cglib;

/**
 * Created by fengxuan1 on 2016/11/25.
 */
public class ProxyFactory {

    public static TestSubject getTestSubjectInstance(String user){
        CglibProxy cglibProxy = new CglibProxy(user);
        return (TestSubject)cglibProxy.getProxy(TestSubject.class);
    }
}
