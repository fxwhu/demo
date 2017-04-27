package javathread.interruptOrStop;

/**
 * Created by fengxuan1 on 2016/12/24.
 */
public class RunTest {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                for (int i = 0; i < 200 ; i++) {
                    if(this.isInterrupted()){
                        System.out.println("停止");
                        break;
                    }else {
                        System.out.println("i: " + i);}
                }
            }
        };



        thread.start();
        thread.sleep(10);
        thread.interrupt();
//        Thread.currentThread().interrupt();
//        System.out.println("main is interrupt: " + Thread.interrupted());
//        System.out.println("main is interrupt: " + Thread.interrupted());
    }
}
