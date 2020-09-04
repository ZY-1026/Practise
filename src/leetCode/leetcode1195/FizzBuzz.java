package leetCode.letcode1195;

import java.util.function.IntConsumer;

/**
 * 交替打印字符串
 * <p>
 * 编写一个可以从 1 到 n 输出代表这个数字的字符串的程序，但是：
 * <p>
 * 如果这个数字可以被 3 整除，输出 "fizz"。
 * 如果这个数字可以被 5 整除，输出 "buzz"。
 * 如果这个数字可以同时被 3 和 5 整除，输出 "fizzbuzz"。
 * 例如，当 n = 15，输出： 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fizz-buzz-multithreaded
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class FizzBuzz {
    private int n;
    private int i;
    private Object lock = new Object();

    public FizzBuzz(int n) {
        this.n = n;
        this.i = 1;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (i <= n) {
            synchronized (lock) {
                while (i <= n && i % 3 == 0 && i % 5 != 0) {
                    printFizz.run();
                    i++;
                }
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (i <= n) {
            synchronized (lock) {
                while (i <= n && i % 3 != 0 && i % 5 == 0) {
                    printBuzz.run();
                    i++;
                }
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (i <= n) {
            synchronized (lock) {
                while (i <= n && i % 3 == 0 && i % 5 == 0) {
                    printFizzBuzz.run();
                    i++;
                }
            }
        }

    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (i <= n) {
            synchronized (lock) {
                while (i <= n && i % 3 != 0 && i % 5 != 0) {
                    printNumber.accept(i);
                    i++;
                }
            }
        }
    }
}
