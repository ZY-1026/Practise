package thread.threadPrint;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程交替打印AB
 */

public class AlternatePrint {
    private static int count = 0;

    // 通过lock实现
    private static void printAB(ReentrantLock lock, boolean flag) {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    lock.lock();
                    while (count % 2 == 0) {
                        System.out.println("A");
                        count++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }, "ThreadA").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    lock.lock();
                    while (count % 2 == 1) {
                        System.out.println("B");
                        count++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }, "ThreadB").start();
    }

    // 通过lock+condition实现
    private static void printAB(ReentrantLock lock) {
        Condition A = lock.newCondition();
        Condition B = lock.newCondition();

        new Thread(() -> {
            try {
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    while (count % 2 != 0) {
                        A.await();
                    }
                    System.out.println("A");
                    count++;
                    B.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "Thread-A").start();

        new Thread(() -> {
            try {
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    while (count % 2 != 1) {
                        B.await();
                    }
                    System.out.println("B");
                    count++;
                    A.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "Thread-B").start();
    }

    // 通过synchronized实现
    private static void printAB() {
        final Object object = new Object();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (object) {
                    try {
                        System.out.println("a");
                        object.wait(); // 释放锁
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }, " A").start();


        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (object) {
                    System.out.println("b");
                    object.notify();
                }
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "B").start();
    }


    public static void main(String[] args) {
        printAB(new ReentrantLock(), true);
    }
}
