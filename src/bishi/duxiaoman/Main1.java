package bishi.duxiaoman;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(" ");
        long n = Long.valueOf(strings[0]).longValue();
        long m = Long.valueOf(strings[1]).longValue();
        long res = 0;
        for (int i = 1; i <= n * 3; i++) {
            res = res + m * i;
        }
        System.out.println(res );
    }
}
