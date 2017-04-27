package springframeTest.applicationEvent.byAutowire;

/**
 * Created by fengxuan1 on 2016/12/7.
 */
public class BlackListEvent2 {

    private String address;

    private String test;

    public BlackListEvent2(String address, String test) {
        this.address = address;
        this.test = test;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

}
