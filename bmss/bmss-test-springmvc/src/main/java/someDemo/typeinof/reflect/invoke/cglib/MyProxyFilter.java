package someDemo.typeinof.reflect.invoke.cglib;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * Created by fengxuan1 on 2016/11/25.
 */
/**
 * 为0拦截，为1不拦截
 */
public class MyProxyFilter implements CallbackFilter {
    @Override
    public int accept(Method method) {
        if (!("find").equalsIgnoreCase(method.getName())) {
            return 0;
        }
        return 1;
    }


}
