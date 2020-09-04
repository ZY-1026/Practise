package leetCode.letcode1114;

import java.util.concurrent.CountDownLatch;

public class Foo {
    public CountDownLatch countDownLatch1;
    public CountDownLatch countDownLatch2;

    public Foo() {
        this.countDownLatch1 = new CountDownLatch(1);
        this.countDownLatch2 = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        countDownLatch1.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        countDownLatch1.await();
        printSecond.run();
        countDownLatch2.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        countDownLatch2.await();
        printThird.run();
    }
}


//public class Foo {
//    public ReentrantLock reentrantLock;
//    public Condition condition1;
//    public Condition condition2;
//
//    public Foo() {
//        this.reentrantLock = new ReentrantLock();
//        this.condition1 = reentrantLock.newCondition();
//        this.condition2 = reentrantLock.newCondition();
//    }
//
//    public void first(Runnable printFirst) throws InterruptedException {
//        reentrantLock.lock();
//        printFirst.run();
//        condition1.signalAll();
//        reentrantLock.unlock();
//    }
//
//    public void second(Runnable printSecond) throws InterruptedException {
//        reentrantLock.lock();
//        condition1.await();
//        printSecond.run();
//        condition2.signalAll();
//        reentrantLock.unlock();
//    }
//
//    public void third(Runnable printThird) throws InterruptedException {
//        reentrantLock.lock();
//        condition2.await();
//        printThird.run();
//        reentrantLock.unlock();
//    }
//}
