package springframeTest.applicationEvent;

import org.springframework.context.ApplicationEvent;

/**
 * Created by fengxuan1 on 2016/12/6.
 */
public class ContentEvent1 extends ApplicationEvent {

    public ContentEvent1(String source) {
        super(source);
    }
}
