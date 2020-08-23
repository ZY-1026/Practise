package bishi.qianxin;

import java.util.Scanner;

public class Test1 {
    public int CalulateMethodCount(int num_money) {
//        int n = num_money;
//        if (n == 0) return 1;
//        int[] dp = new int[n + 1];
//        for (int i = 1; i <= n; i++) {
//            int sum = 1;
//            for (int j = 1; j < i; j++) {
//                sum += dp[j];
//            }
//            dp[i] = sum;
//        }
//        return dp[n];
        if (num_money == 1) return 1;
        if (num_money == 2) return 2;
        if (num_money == 3) return 4;
        long[] dp = new long[num_money + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= num_money; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000007;
        }
        return (int) dp[num_money];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(new Test1().CalulateMethodCount(n));
    }
}
