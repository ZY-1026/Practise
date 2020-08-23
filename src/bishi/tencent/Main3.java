package bishi.tencent;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n > 0) {
            int res = 0;
            int num = sc.nextInt();
            for (int i = 1; i <= num / 2 + 1; i++) {
                res = Math.max(res, getVal(i) + getVal(num - i));
            }
            n--;
            System.out.println(res);
        }
    }

    public static int getVal(int i) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }
        return sum;
    }
}
