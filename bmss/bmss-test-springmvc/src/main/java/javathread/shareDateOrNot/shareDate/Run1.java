package javathread.shareDateOrNot.shareDate;

/**
 * Created by fengxuan1 on 2016/12/21.
 */
public class Run1 {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread a = new Thread(myThread, "A");
        Thread b = new Thread(myThread, "B");
        Thread c = new Thread(myThread, "C");
        Thread e = new Thread(myThread, "D");
        Thread f = new Thread(myThread, "F");
        a.start();
        b.start();
        c.start();
        e.start();
        f.start();
    }
}
