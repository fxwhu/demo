package springframeTest.applicationEvent.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by fengxuan1 on 2016/12/7.
 */
@Component
public class TestBeanValue {
    @Value("#{'test1,test2,test3'.split(',')}")
    private List<String> names;

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

}
