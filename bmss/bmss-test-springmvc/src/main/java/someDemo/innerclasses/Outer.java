package someDemo.innerclasses;

/**
 * Created by fengxuan1 on 2016/11/20.
 */
public class Outer {

    private String s;

    public Outer(String s) {
        this.s = s;
    }

    class Shower{
        public void toshow(){
//            String j = Outer.this.s;
            System.out.println(s);
        }
    }

    public Shower shower(){
        return new Shower();
    }

    public static void main(String[] args) {
        Outer outer = new Outer("test");
        outer.shower().toshow();
    }
}
