package com.bmss;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by fengxuan1 on 2017/3/23.
 */
public class ConditionTest {

    private static Logger logger = LoggerFactory.getLogger(ReentrantLockTest.class);



    static ReentrantLock lockTestCondition = new ReentrantLock();
    static Condition condition = lockTestCondition.newCondition();



    @Test
    public void testCondition() throws InterruptedException {

        Thread thread = new Thread(new ConditionTest2(lockTestCondition, condition));
        Thread thread1 = new Thread(new ConditionTest1(lockTestCondition, condition));

        thread.start();
        Thread.sleep(1000);
        thread1.start();
        Thread.sleep(5000);

    }


    private static class ConditionTest2 implements Runnable{
        private Lock lock;

        private Condition condition1;

        public ConditionTest2(Lock lock, Condition condition1) {
            this.lock = lock;
            this.condition1 = condition1;
        }

        @Override
        public void run() {
            lock.lock();
            try {
                logger.info("ConditionTest await");
                condition1.await();
                logger.info("ConditionTest continus");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {

                lock.unlock();
            }

            logger.info("ConditionTest......");
        }
    }

    private static class ConditionTest1 implements Runnable{
        private Lock lock;

        private Condition condition1;


        public ConditionTest1(Lock lock, Condition condition1) {
            this.lock = lock;
            this.condition1 = condition1;
        }

        @Override
        public void run() {
            lock.lock();
            try {
                logger.info("ConditionTest1 await");
                condition1.signal();
                logger.info("ConditionTest1 signal");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

                lock.unlock();
            }

            logger.info("ConditionTest1......");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Thread thread = new Thread(new ThreadA(lock));
        Thread thread2 = new Thread(new ThreadB(lock));
        thread.start();
        thread2.start();
        Thread.sleep(5000);

    }

    private static class Service{
        public void waitMethod(Object lock){
            try {
                synchronized (lock){
                    logger.info("begin wait");
                    lock.wait();
                    logger.info("end wait");
                }
                logger.info("waitMethod....");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void notifyMethod(Object lock){
            try {
                synchronized (lock){
                    logger.info("begin notify");
                    lock.notify();
                    logger.info("end notify");
                }
                logger.info("notifyMethod....");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    private static class ThreadA implements Runnable{

        private Object lock;

        public ThreadA(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            Service service = new Service();
            service.waitMethod(lock);
        }
    }
    private static class ThreadB implements Runnable{

        private Object lock;

        public ThreadB(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            Service service = new Service();
            service.notifyMethod(lock);
        }
    }





}
