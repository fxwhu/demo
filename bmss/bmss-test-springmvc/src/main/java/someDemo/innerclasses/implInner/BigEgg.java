package someDemo.innerclasses.implInner;

/**
 * Created by fengxuan1 on 2016/11/20.
 */
public class BigEgg extends Egg{

    public BigEgg() {
        System.out.println("BigEgg");
        addYork(new YorkImpl());
    }

    class YorkImpl extends York{
        public YorkImpl() {
            System.out.println("BigEgg YorkImpl");
        }

        @Override
        public void f() {
            System.out.println("BigEgg YorkImpl f()");
        }
    }

    public static void main(String[] args) {
        Egg egg = new BigEgg();
        egg.g();
    }
}
