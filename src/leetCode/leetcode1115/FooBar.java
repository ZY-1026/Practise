package leetCode.letcode1115;

/**
 * 交叉打印FooBar
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class FooBar {
    private int n;
    private ReentrantLock lock = new ReentrantLock();
    private Condition fooCondition = lock.newCondition();
    private Condition barCondition = lock.newCondition();
    private int count = 1;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            if (count != 1) {
                fooCondition.await();
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            barCondition.signal();
            count = 2;
            lock.unlock();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            if (count != 2) {
                barCondition.await();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            fooCondition.signal();
            count = 1;
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable printFoo = new Runnable() {
            @Override
            public void run() {
                System.out.print("foo");
            }
        };

        Runnable printBar = new Runnable() {
            @Override
            public void run() {
                System.out.print("bar");
            }
        };

        FooBar fooBar = new FooBar(2);
        fooBar.foo(printFoo);
        fooBar.bar(printBar);
    }
}
