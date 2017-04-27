package someDemo.typeinof.reflect.invoke;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by fengxuan1 on 2016/11/25.
 */
public class MyInvocationHandler implements InvocationHandler {
    private Object object = null;

    public Object bind(Object object){
        this.object = object;
//        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(),
//                this);
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("begin invoke");
        System.out.println("args: " + JSON.toJSONString(args));
        return method.invoke(this.object, args);
    }
}
