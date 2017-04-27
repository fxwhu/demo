package someDemo.innerclasses.NestInner;

/**
 * Created by fengxuan1 on 2016/11/20.
 */
public class Egg {

    private int i;

    static class A{

        public void test(){
//            i = i + 1; 嵌套的static内部类类似static方法
//            f();
            g();
        }
    }

    void f(){}

    static void g(){}
}
