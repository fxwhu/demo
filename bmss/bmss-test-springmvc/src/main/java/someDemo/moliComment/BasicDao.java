package someDemo.moliComment;

import java.io.Serializable;

/**
 * Created by fengxuan1 on 2016/11/17.
 */
public interface BasicDao<T extends Serializable> {
    public void method1();
    public void method2();
    public void method3();
}
