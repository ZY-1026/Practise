package bishi.tencent;


public class Main5 {
    private static int minCut(String s) {
        int len = s.length();
        if (len < 2) return 0;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) dp[i] = i;
        for (int i = 1; i < len; i++) {
            if (helper(s, 0, i)) {
                dp[i] = 0;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (helper(s, j + 1, i)) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[len - 1] + 1;
    }

    private static boolean helper(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(minCut("ababa"));
    }
}
