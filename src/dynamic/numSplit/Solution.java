package dynamic.numSplit;

public class Solution {
    // 整数n，拆分成最大为k的组合
    public static int dp(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        if (n == 1 || k == 1) {
            dp[n][k] = 1;
            return dp[n][k];
        } else if (n < k) {
            dp[n][k] = dp(n, n);
            return dp[n][k];
        } else if (n == k) {
            dp[n][k] = dp(n, k - 1) + 1;
            return dp[n][k];
        } else {
            dp[n][k] = dp(n, k - 1) + dp(n - k, k);
            return dp[n][k];
        }
    }

    public static void main(String[] args) {
        System.out.println(dp(3,3));
    }
}
