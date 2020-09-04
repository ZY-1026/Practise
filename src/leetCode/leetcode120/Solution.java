package leetCode.letcode120;

import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * <p>
 *  
 * <p>
 * 例如，给定三角形：
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null) return 0;
        if (triangle.size() == 0) return 0;
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
            }
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int min = dp[n - 1][0];
        for (int i = 1; i < n; i++) {
            min = Math.min(min, dp[n - 1][i]);
        }
        return min;
    }


    public static int minNumberInRotateArray(int n[][]) {
        int max = 0;
        int dp[][] = new int[n.length][n.length];
        dp[0][0] = n[0][0];
        for (int i = 1; i < n.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    //如果是第一列，直接跟他上面数字相加
                    dp[i][j] = dp[i - 1][j] + n[i][j];
                } else {
                    //如果不是第一列，比较他上面跟上面左面数字谁大，谁大就跟谁相加，放到这个位置
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + n[i][j];
                }
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }
}
