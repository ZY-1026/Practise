package leetCode.letcode300;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        // dp[i]代表以第i个元素结尾的最长上升子序列, nums[i]必须被选中
        // 状态转移方程：dp[i] = max(dp[j]) + 1
        // 即在0....i-1中的最长子序列加上num[i]
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }
}
