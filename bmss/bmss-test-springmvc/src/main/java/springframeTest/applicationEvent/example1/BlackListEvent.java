package springframeTest.applicationEvent.example1;

import org.springframework.context.ApplicationEvent;

/**
 * Created by fengxuan1 on 2016/12/6.
 */
public class BlackListEvent extends ApplicationEvent{

    private final String address;

    private final String test;

    public String getAddress() {
        return address;
    }

    public String getTest() {
        return test;
    }

    public BlackListEvent(Object source, String address, String test) {
        super(source);
        this.address = address;
        this.test = test;
        System.out.println("black event created!");
    }
}
