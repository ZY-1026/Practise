package dynamic.test2;

/**
 * 最长公共连续子串
 */

public class Solution {
    private static int maxlength(String s, String t) {
        int ans = 0;
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(dp[i][j], ans);
                } else {
                    dp[i][j] = 0;
                }
            }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxlength("abcde", "abgde"));
        byte a = 2;
        System.out.println(a);
    }
}
