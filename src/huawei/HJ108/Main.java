package huawei.HJ108;

import java.util.Scanner;

/**
 * 题目描述
 * 正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，
 * 设计一个算法，求输入A和B的最小公倍数。
 * <p>
 * 输入描述:
 * 输入两个正整数A和B。
 * <p>
 * 输出描述:
 * 输出A和B的最小公倍数。
 * <p>
 * 示例1
 * 输入
 * 复制
 * 5 7
 * 输出
 * 复制
 * 35
 */

public class Main {
    // 求两个数的最大公约数
    private static int fun1(int m, int n) {
        if (n == 0) return m;
        return fun1(n, m % n);
    }

    // 计算最小公倍数
    public static int fun2(int a, int b) {
        return (a * b) / fun1(a, b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            System.out.println(fun2(m, n));
        }
    }
}
