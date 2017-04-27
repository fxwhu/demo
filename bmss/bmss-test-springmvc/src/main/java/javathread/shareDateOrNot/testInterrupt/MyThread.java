package javathread.shareDateOrNot.testInterrupt;

/**
 * Created by fengxuan1 on 2016/12/22.
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 20; i++) {
            System.out.println("i= " + (i + 1));
        }
    }
}
