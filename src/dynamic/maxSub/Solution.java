package dynamic.maxSub;

/**
 * 动态规划求解最大子序和
 */
public class Solution {
    public static int max(int x, int y) {
        return x > y ? x : y;
    }


    public static int maxSubSum(int[] a) {
        int dp = 0;
        int result = a[0];
        for (int i = 0; i < a.length; i++) {
            dp = max(dp + a[i], a[i]);
            result = max(result, dp);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {-2, 11, -4, 13, -5, -2};
        System.out.println(maxSubSum(a));
    }
}
