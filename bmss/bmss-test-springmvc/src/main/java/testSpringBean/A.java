package testSpringBean;

import org.springframework.stereotype.Component;

/**
 * Created by fengxuan1 on 2016/11/18.
 */
@Component
public class A {
    private int a;
    {
        a = 1;
    }

    public A() {
        this.a = a + 1;
    }

    public void test(){
        System.out.println(a);
    }
}
