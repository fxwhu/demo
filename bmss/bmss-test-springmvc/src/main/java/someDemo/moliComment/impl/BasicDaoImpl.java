package someDemo.moliComment.impl;


import someDemo.moliComment.BasicDao;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by fengxuan1 on 2016/11/17.
 */
@Component
public class BasicDaoImpl<T extends Serializable> implements BasicDao {
    @Override
    public void method1() {
        System.out.println("method1");
    }

    @Override
    public void method2() {
        System.out.println("method2");
    }

    @Override
    public void method3() {
        System.out.println("method3");
    }
}
