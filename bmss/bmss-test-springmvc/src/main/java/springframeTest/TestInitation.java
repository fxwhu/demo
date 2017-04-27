package springframeTest;

import org.springframework.beans.factory.InitializingBean;

/**
 * Created by fengxuan1 on 2016/12/6.
 */
public class TestInitation implements InitializingBean{

    public void init(){
        System.out.println("=======init method======");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("=======afterPropertiesSet==========");
    }
}
