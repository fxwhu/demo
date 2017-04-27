package javathread.test1;

/**
 * Created by fengxuan1 on 2016/12/21.
 */
public class Run {

    public static void main(String[] args) {
        for (int i = 0; i < 20 ; i++) {
            MyThread thread = new MyThread();
            thread.start();
        }
        System.out.println(Thread.currentThread().getName() + " end");
    }

}
