package someDemo.innerclasses.implInner;

/**
 * Created by fengxuan1 on 2016/11/20.
 */
public class Egg {
    private York york = new York();

    public Egg() {
        System.out.println("egg begin");
    }

    public void addYork(York york){
        this.york = york;
    }

    public void g(){
        york.f();
    }

    protected class York{
        public York() {
            System.out.println("egg york");
        }
        public void f(){
            System.out.println("egg york f()");
        }
    }
}
