package someDemo.testExtend;

/**
 * Created by fengxuan1 on 2016/11/20.
 */
public class A {

    private static int a;

    private static Integer b;

    public A() {
        System.out.println("A" + a + "===" + b);
    }

    public static void main(String[] args) {
        new A();
    }
}
