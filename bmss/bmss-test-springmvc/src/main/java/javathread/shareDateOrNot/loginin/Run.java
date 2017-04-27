package javathread.shareDateOrNot.loginin;

/**
 * Created by fengxuan1 on 2016/12/21.
 */
public class Run {
    public static void main(String[] args) {
        ALogin a = new ALogin();
        a.start();
        BLogin b = new BLogin();
        b.start();
    }
}
