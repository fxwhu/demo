package javathread.shareDateOrNot.testInterrupt;

/**
 * Created by fengxuan1 on 2016/12/22.
 */
public class Run {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
