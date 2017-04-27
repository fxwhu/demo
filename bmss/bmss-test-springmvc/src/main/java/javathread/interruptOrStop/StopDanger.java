package javathread.interruptOrStop;

/**
 * Created by fengxuan1 on 2016/12/24.
 */
public class StopDanger {

    public class TestThread extends Thread{
        private SynchronizedObject object;
        public TestThread(SynchronizedObject object){
            this.object = object;
        }

        @Override
        public void run() {
            super.run();
            object.propertiesReset("b", "bbb");
        }
    }

    public class SynchronizedObject {
        private String name, message;

        public SynchronizedObject(String name, String message) {
            this.name = name;
            this.message = message;
        }

        synchronized public void propertiesReset(String name, String message){
            try {
                this.name = name;
                Thread.sleep(20000);
                this.message = message;
            } catch (InterruptedException e) {
                System.out.println("被打断了");
                e.printStackTrace();
            }
        }
    }

    public SynchronizedObject getSynchronizedObject(String name, String message){
        return new SynchronizedObject(name, message);
    }

    public TestThread getTestThread(SynchronizedObject object){
        return new TestThread(object);
    }

    public static void main(String[] args) {
        try {
            StopDanger stopDanger = new StopDanger();
            SynchronizedObject synchronizedObject = stopDanger.getSynchronizedObject("a", "aaa");
            TestThread testThread = stopDanger.getTestThread(synchronizedObject);
            testThread.start();
            testThread.sleep(100);
//            testThread.stop();
            testThread.interrupt();
            System.out.println(synchronizedObject.message + " : " + synchronizedObject.name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
