package javathread.test1;

/**
 * Created by fengxuan1 on 2016/12/21.
 */
public class MyThread extends Thread{

    @Override
    public void run() {
        super.run();
        System.out.println(Thread.currentThread().getName() + " MyThread");
    }
}
