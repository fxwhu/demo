package javathread.shareDateOrNot.notShareDate;

/**
 * Created by fengxuan1 on 2016/12/21.
 */
public class Run {
    public static void main(String[] args) {
        MyThread threadA = new MyThread("A");
        MyThread threadB = new MyThread("B");
        threadA.start();
        threadB.start();
    }
}
