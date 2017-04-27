package javathread.shareDateOrNot.notShareDate;

/**
 * Created by fengxuan1 on 2016/12/21.
 */
public class MyThread extends Thread{
    private int count = 5;

    public MyThread(String name) {
        super();
        this.setName(name);
    }

    @Override
    public void run() {
        super.run();
        while (count > 0){
            count --;
            System.out.println("sub by " + this.currentThread().getName() + " result : " + count);
        }
    }
}
