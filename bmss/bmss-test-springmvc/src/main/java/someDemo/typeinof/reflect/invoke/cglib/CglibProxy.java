package someDemo.typeinof.reflect.invoke.cglib;

import net.sf.cglib.proxy.*;

import java.lang.reflect.Method;

/**
 * Created by fengxuan1 on 2016/11/25.
 */
public class CglibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    private String user;

    public CglibProxy(String user) {
        this.user = user;
    }

    /**
     * 获取增强的目标类的工厂Factory，其中增强的方法类对象是有Enhancer来实现的
     *
     */
    public Object getProxy(Class clazz){
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);

        /**
         *添加了方法过滤器需要设置相应的callbacks,其顺序应该与filter中的顺序一致
         */
        enhancer.setCallbacks(new Callback[]{this, NoOp.INSTANCE});
        enhancer.setCallbackFilter(new MyProxyFilter());
        return enhancer.create();
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if(!("root").equals(user)){
            System.out.println("对不起没权限操作");
            return null;
        }
        Object result = methodProxy.invokeSuper(o, objects);
        return result;
    }

    public void test() {
        System.out.println("=============");
    }
}
