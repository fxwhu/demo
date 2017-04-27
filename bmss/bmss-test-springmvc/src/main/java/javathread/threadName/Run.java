package javathread.threadName;

/**
 * Created by fengxuan1 on 2016/12/22.
 */
public class Run {
    public static void main(String[] args) {
        CountOperate c = new CountOperate();
        Thread t1 = new Thread(c);
        System.out.println("main begin t1 is alive: " + t1.isAlive());
        t1.setName("A");
        t1.start();
        System.out.println("main end t1 is alive: " + t1.isAlive());
    }
}
