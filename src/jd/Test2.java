package jd;

import java.util.Scanner;

public class Test2 {
    public static void primeTable(boolean[] isPrimes) {
        int num = isPrimes.length;
        for (int i = 2; i < num; i++) {
            isPrimes[i] = true;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (isPrimes[i] == true) {
                for (int j = 2; i * j < num; j++) {
                    isPrimes[i * j] = false;
                }
            }
        }
    }

    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }

    public static boolean match(boolean[] isPrimes, int cur) {
        for (int base = 1; base <= cur; base *= 10) {
            int tmp = (cur / (base * 10)) * base + cur % base;
            if (isPalindrome(tmp) && isPrimes[tmp]) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, M;
        N = sc.nextInt();
        M = sc.nextInt();
        boolean[] isPrimes = new boolean[M + 1];
        primeTable(isPrimes);
        int count = 0;
        for (int index = N; index <= M; index++) {
            if (match(isPrimes, index)) count++;
        }
        System.out.println(count);
        sc.close();
    }
}
