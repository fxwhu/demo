package javathread.obejectAccess;

/**
 * Created by fengxuan1 on 2016/12/26.
 */
public class ThreadA extends Thread {

    private AddNum addNum;

    public ThreadA(AddNum addNum) {
        this.addNum = addNum;
    }

    @Override
    public void run() {
        super.run();
        addNum.add("a");
    }
}
