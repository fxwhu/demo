package javathread.threadName;

/**
 * Created by fengxuan1 on 2016/12/22.
 */
public class CountOperate extends Thread {

    public CountOperate() {
        System.out.println("CountOperate---begin");
        System.out.println("Thread.currentThread().getName(): " + Thread.currentThread().getName() + " is alive: "
                + Thread.currentThread().isAlive());
        System.out.println("name: " + this.getName() + "  is alive: " + this.isAlive());
        System.out.println("CountOperate---end");
    }

    @Override
    public void run() {
        System.out.println("CountOperate---begin");
        System.out.println("Thread.currentThread().getName(): " + Thread.currentThread().getName() + " is alive: "
                + Thread.currentThread().isAlive());
        System.out.println("name: " + this.getName() + "  is alive: " + this.isAlive());
        System.out.println("CountOperate---end");
    }
}
