package springframeTest.applicationEvent.example1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by fengxuan1 on 2016/12/6.
 */
@Component
public class EmailService implements ApplicationEventPublisherAware {

    @Value("#{'known.spammer@example.org,known.hacker@example.org,john.doe@example.org'.split(',')}")
    private List<String> blackList;

    private ApplicationEventPublisher publisher;

    public void setBlackList(List<String> blackList) {
        this.blackList = blackList;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }


    public void sendEmail(String address, String test){
        if(blackList.contains(address)) {
            BlackListEvent event = new BlackListEvent(this, address, test);
            publisher.publishEvent(event);
            return;
        }
    }
}
