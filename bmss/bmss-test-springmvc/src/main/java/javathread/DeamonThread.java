package javathread;

/**
 * Created by fengxuan1 on 2016/12/26.
 */
public class DeamonThread {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                for (int i = 0; i < 100; i++) {
                    System.out.println("i: " + i);
                }
            }
        };

        thread.setDaemon(true);
        thread.start();
        Thread.sleep(20);
        System.out.println("stop!");
    }
}
