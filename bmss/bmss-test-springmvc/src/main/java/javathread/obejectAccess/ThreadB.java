package javathread.obejectAccess;

/**
 * Created by fengxuan1 on 2016/12/26.
 */
public class ThreadB extends Thread {

    private AddNum addNum;

    public ThreadB(AddNum addNum) {
        this.addNum = addNum;
    }

    @Override
    public void run() {
        super.run();
        addNum.add("b");
    }
}
