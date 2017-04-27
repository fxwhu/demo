package someDemo.innerclasses.implInner;

/**
 * Created by fengxuan1 on 2016/11/20.
 */
public class InheritInner {
    public class InnerImpl extends WithInner.Inner{

        public InnerImpl(WithInner withInner, int i) {
            withInner.super(i);
        }
    }
}
