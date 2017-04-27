package javathread.shareDateOrNot.shareDate;

/**
 * Created by fengxuan1 on 2016/12/21.
 */
public class MyThread extends Thread{
    private int count = 5;

    @Override
    synchronized public void run() {
        super.run();
        while (count > 0){
            count --;
            System.out.println("sub by " + this.currentThread().getName() + " result : " + count);
        }
    }
}
