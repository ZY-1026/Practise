package bishi.tencent;

import java.util.Scanner;

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
        return dp[len - 1];
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
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.nextLine();
        int Q = sc.nextInt();
        sc.nextLine();
        while (Q > 0) {
            String[] strings = sc.nextLine().split(" ");
            int left = Integer.valueOf(strings[0]);
            int right = Integer.valueOf(strings[1]);
            String tmp = s.substring(left-1, right);
            System.out.println(minCut(tmp));
            Q--;
        }
    }
}
