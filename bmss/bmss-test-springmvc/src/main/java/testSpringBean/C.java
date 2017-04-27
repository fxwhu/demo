package testSpringBean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by fengxuan1 on 2016/11/18.
 */
@Component
public class C implements InitializingBean {
    @Autowired
    B b;

    private int age;
    public C() {
    }

    public void test(){
        System.out.println(age);
    }

    public void init(){
        age = b.getAge() + 1;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        init();
    }
}
