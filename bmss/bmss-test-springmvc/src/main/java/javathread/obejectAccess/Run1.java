package javathread.obejectAccess;

/**
 * Created by fengxuan1 on 2016/12/26.
 */
public class Run1 {
    public static void main(String[] args) {
        AddNum addNum = new AddNum();
        AddNum addNum2 = new AddNum();
        ThreadA threadA = new ThreadA(addNum);
        threadA.start();
        ThreadB threadB = new ThreadB(addNum2);
        threadB.start();
    }
}
