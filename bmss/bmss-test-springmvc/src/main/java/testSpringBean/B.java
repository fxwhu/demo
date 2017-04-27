package testSpringBean;

import org.springframework.stereotype.Component;

/**
 * Created by fengxuan1 on 2016/11/18.
 */
@Component
public class B {
    private int age;
    {
        age = 1;
    }

    public int getAge(){
        return age;
    }
}
