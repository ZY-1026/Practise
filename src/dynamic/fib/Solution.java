package dynamic.fib;

/**
 * 动态规划求解斐波拉切数列
 */
public class Solution {
    public static int fib(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0; //dp[0]不存放数据
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int result = fib(6);
        System.out.println(result);
    }
}
