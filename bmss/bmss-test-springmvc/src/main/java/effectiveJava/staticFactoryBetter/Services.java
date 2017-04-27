package effectiveJava.staticFactoryBetter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by fengxuan1 on 2016/11/20.
 */
public class Services {

    private final static Map<String, Provider> provides = new ConcurrentHashMap<>();

    public final static String DEFAULT_PROVIDER_NAME = "DEFAULT";

    static{
        provides.put(DEFAULT_PROVIDER_NAME, DefaultService.provider);
    }

    public static void resgisterProvider(String name, Provider provider){
        provides.put(name, provider);
    }

    public static Service newInstance(){
        return newInstance(DEFAULT_PROVIDER_NAME);
    }

    public static Service newInstance(String name){
        Provider p = provides.get(name);
        if(p != null){
            return p.newService();
        }else {
            throw new IllegalArgumentException("error name for provider");
        }
    }
}
