package springframeTest.applicationEvent.example1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by fengxuan1 on 2016/12/7.
 */
@Component
public class BlackListNotifier implements ApplicationListener<BlackListEvent> {

    @Value("1111111111@example.org")
    private String notificationAddress;

    public void setNotificationAddress(String notificationAddress) {
        this.notificationAddress = notificationAddress;
    }

    @Override
    public void onApplicationEvent(BlackListEvent blackListEvent) {
        System.out.println(notificationAddress + " has recieved messsage from : " + blackListEvent.getAddress() + " ," +
                " content is :" + blackListEvent.getTest());
    }
}
