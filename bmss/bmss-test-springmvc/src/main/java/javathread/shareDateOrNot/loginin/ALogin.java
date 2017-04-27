package javathread.shareDateOrNot.loginin;

/**
 * Created by fengxuan1 on 2016/12/21.
 */
public class ALogin extends Thread{
    @Override
    public void run() {
        LoginServletA.doPost("a", "aa");
    }
}
