package leetCode.mytest;

import java.util.HashSet;

public class SeqSub {
    /**
     * 两个字符串的最长连续子序列
     *
     * @param text1
     * @param text2
     * @return
     */
    private int longCommonSubSeq(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c1 = text1.charAt(i), c2 = text2.charAt(j);
                if (c1 == c2) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[m][n];
    }

    /**
     * 两个字符串的最长连续子串
     *
     * @param A 字符串
     * @param B 字符串
     * @return 返回最长连续字串
     */
    private static String longCommonString(String A, String B) {
        int[][] dp = new int[B.length()][A.length()];
        int end_index = 0;
        int maxLength = 0;
        for (int i = 0; i < A.length(); i++) {
            for (int j = 0; j < B.length(); j++) {
                if (B.charAt(j) == A.charAt(i)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        end_index = j;
                    }
                }
            }
        }
        System.out.println("maxLength=" + maxLength);
        System.out.println("endLength=" + end_index);
        end_index += 1;
        return B.substring(end_index - maxLength, end_index);
    }

    /**
     * 一个字符串的最长连续字串
     *
     * @param s 字符串s
     * @return 返回最长连续字串
     */
    private static String longCommonString(String s) {
        int n = s.length();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = (int) s.charAt(i) - (int) 'a';
        int a = 26;
        long m = (long) Math.pow(2, 32);
        int left = 1, right = n;
        int L;
        while (left != right) {
            L = left + (right - left) / 2;
            if (search(L, a, m, n, nums) != -1) left = L + 1;
            else right = L;
        }
        int start = search(left - 1, a, m, n, nums);
        return start != -1 ? s.substring(start, start + left - 1) : "";
    }

    private static int search(int L, int a, long m, int n, int[] nums) {
        long h = 0;
        for (int i = 0; i < L; i++) h = (h * a + nums[i]) % m;
        HashSet<Long> seen = new HashSet<>();
        seen.add(h);
        long aL = 1;
        for (int i = 1; i <= L; i++) aL = (aL * a) % m;
        for (int start = 1; start < n - L + 1; start++) {
            h = (h * a - nums[start - 1] * aL % m + m) % m;
            h = (h + nums[start + L - 1]) % m;
            if (seen.contains(h)) return start;
            seen.add(h);
        }
        return -1;
    }


    public static void main(String[] args) {
        String str = longCommonString("abcdcd");
        System.out.println(str);
    }
}
