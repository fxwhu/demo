package com.bmss;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by fengxuan1 on 2017/3/22.
 */
public class ReentrantLockTest {
    private static Logger logger = LoggerFactory.getLogger(ReentrantLockTest.class);

    static ReentrantLock unfairLock = new ReentrantLock2();
    static ReentrantLock fairLock = new ReentrantLock2(true);


    static ReentrantLock lockTestCondition = new ReentrantLock();
    static Condition lockCondition = lockTestCondition.newCondition();
    static Condition lockCondition2 = lockTestCondition.newCondition();

    @Test
    public void fair() throws InterruptedException {
        System.out.println("fair lock");
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Job(fairLock)){
                public String toString(){
                    return getName();
                }
            };

            thread.setName("" + i);
            thread.start();
        }
        Thread.sleep(5000);
    }

    @Test
    public void unfair() throws InterruptedException {
        System.out.println("unfair lock");
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Job(unfairLock)){
                public String toString(){
                    return getName();
                }
            };
            thread.setName("" + i);
            thread.start();
        }
        Thread.sleep(5000);

    }


    @Test
    public void testCondition() throws InterruptedException {

        Thread thread = new Thread(new ConditionTest(lockTestCondition, lockCondition, lockCondition2));
        Thread thread1 = new Thread(new ConditionTest1(lockTestCondition, lockCondition, lockCondition2));

        thread.start();
        Thread.sleep(1000);
        thread1.start();
        Thread.sleep(5000);

    }


    private static class ConditionTest implements Runnable{
        private Lock lock;

        private Condition condition1;

        private Condition condition2;


        public ConditionTest(Lock lock, Condition condition1, Condition condition2) {
            this.lock = lock;
            this.condition1 = condition1;
            this.condition2 = condition2;
        }

        @Override
        public void run() {
            lock.lock();
            try {
                logger.info("ConditionTest condition1 await");
                condition1.await();
                logger.info("ConditionTest condition1 continus");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }


            lock.lock();
            try {
                logger.info("ConditionTest lockCondition2 await");
                condition2.signal();
                logger.info("ConditionTest lockCondition2 signal");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    private static class ConditionTest1 implements Runnable{
        private Lock lock;

        private Condition condition1;

        private Condition condition2;

        public ConditionTest1(Lock lock, Condition condition1, Condition condition2) {
            this.lock = lock;
            this.condition1 = condition1;
            this.condition2 = condition2;
        }

        @Override
        public void run() {
            lock.lock();
            try {
                logger.info("ConditionTest1 condition1 await");
                condition1.signal();
                logger.info("ConditionTest1 condition1 signal");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }


            if(lock.tryLock()){
                try {
                    logger.info("ConditionTest1 lockCondition2 await");
                    condition2.wait();
                    logger.info("ConditionTest1 lockCondition2 continus");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }else {
                logger.info("======");
            }
        }
    }








    private static class Job implements Runnable{
        private Lock lock;

        public Job(Lock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                lock.lock();
                try {
                    Thread.sleep(100);
                    System.out.println("lock by: " + Thread.currentThread().getName() + " and "
                            + ((ReentrantLock2) lock).getQueuedThreads() + " waits");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }


    private static class ReentrantLock2 extends ReentrantLock{

        public ReentrantLock2() {
            super();
        }

        public ReentrantLock2(boolean fair) {
            super(fair);
        }

        private static final long serialVersionUID = 1773716895097002072L;

        @Override
        public Collection<Thread> getQueuedThreads() {
            return super.getQueuedThreads();
        }
    }
}
