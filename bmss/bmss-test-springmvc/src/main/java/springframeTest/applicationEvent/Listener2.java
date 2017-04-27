package springframeTest.applicationEvent;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by fengxuan1 on 2016/12/6.
 */
@Component
public class Listener2 implements SmartApplicationListener {
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> aClass) {
        if(aClass == ContentEvent2.class){
            return true;
        }
        return false;
    }

    @Override
    public boolean supportsSourceType(Class<?> aClass) {
        return aClass == String.class;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println("====listener2 收到消息====" + applicationEvent.getSource());
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
