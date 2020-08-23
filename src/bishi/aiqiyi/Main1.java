package bishi.aiqiyi;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        long n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextLong();
        long count = 0L;
        long tmp = n / 5;
        while (tmp != 0) {
            count += tmp;
            tmp = tmp / 5;
        }
        System.out.println(count);
    }
}
