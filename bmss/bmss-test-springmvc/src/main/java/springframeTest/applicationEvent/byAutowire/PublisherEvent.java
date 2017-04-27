package springframeTest.applicationEvent.byAutowire;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * Created by fengxuan1 on 2016/12/7.
 */
@Component
public class PublisherEvent implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    public void sendEmail(String address, String message ){
        publisher.publishEvent(new BlackListEvent2(address, message));
    }
}
