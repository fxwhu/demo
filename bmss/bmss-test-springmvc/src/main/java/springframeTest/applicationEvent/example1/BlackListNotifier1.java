package springframeTest.applicationEvent.example1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created by fengxuan1 on 2016/12/7.
 */
@Component
public class BlackListNotifier1{

    @Value("listener2@example.org")
    private String notificationAddress;

    public void setNotificationAddress(String notificationAddress) {
        this.notificationAddress = notificationAddress;
    }

    @EventListener({BlackListEvent.class})
    public void handleChange(BlackListEvent blackListEvent) {
        System.out.println(notificationAddress + " has recieved messsage from : " + blackListEvent.getAddress() + " ," +
                " content is :" + blackListEvent.getTest());
    }
}
