package someDemo.innerclasses;

/**
 * Created by fengxuan1 on 2016/11/20.
 */
public class Test {

    public static void main(String[] args) {
        Outer outer = new Outer("test");
        Outer.Shower shower = outer.new Shower();
        shower.toshow();
    }
}
