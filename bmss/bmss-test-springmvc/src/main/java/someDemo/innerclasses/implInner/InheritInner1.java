package someDemo.innerclasses.implInner;

/**
 * Created by fengxuan1 on 2016/11/20.
 */
public class InheritInner1 extends WithInner.Inner{
    public InheritInner1(WithInner withInner, int i) {
        withInner.super(i);
    }
}
