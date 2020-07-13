package huawei.HJ107;

import java.util.Scanner;

/**
 * 求一个数的立方根
 * <p>
 * 牛顿迭代法
 */

public class Main {
    public static double Solution(double num) {
        if (num == 0) {
            return num;
        }
        double num1, num2;
        num1 = num;
        num2 = (2 * num1 + num / num1 / num1) / 3;
        while (Math.abs(num2 - num1) > 0.000001) {
            num1 = num2;
            num2 = (2 * num1 + num / num1 / num1) / 3;
        }
        return (double) Math.round(num1 * 10.0) / 10.0;
    }

    public static void main(String[] args) {
        double num = new Scanner(System.in).nextDouble();
        System.out.println(Solution(num));
    }
}
