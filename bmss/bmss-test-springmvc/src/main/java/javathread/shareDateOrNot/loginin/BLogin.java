package javathread.shareDateOrNot.loginin;

/**
 * Created by fengxuan1 on 2016/12/21.
 */
public class BLogin extends Thread{
    @Override
    public void run() {
        LoginServletA.doPost("b", "bb");
    }
}
