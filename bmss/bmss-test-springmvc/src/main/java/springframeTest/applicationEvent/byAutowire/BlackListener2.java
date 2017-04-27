package springframeTest.applicationEvent.byAutowire;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by fengxuan1 on 2016/12/7.
 */
@Component
public class BlackListener2 {
    @Value("22222@example.org")
    private String notificationAddress;

    public void setNotificationAddress(String notificationAddress) {
        this.notificationAddress = notificationAddress;
    }

    @EventListener()
    @Order(0)
    //,condition = "#event.test == 'test'"
    public void listenSendEmail(BlackListEvent2 event){
        System.out.println(notificationAddress + " has recieved messsage from : " + event.getAddress() + " ," +
                " content is :" + event.getTest());
    }

    @EventListener()
    @Order(1)
    //,condition = "#event.test == 'test'"
    public void listenSendEmail1(BlackListEvent2 event){
        System.out.println("======" + notificationAddress + " has recieved messsage from : " + event.getAddress() + "" +
                " , content is :" + event.getTest());
    }


    public void listenSend(){

    }
}
