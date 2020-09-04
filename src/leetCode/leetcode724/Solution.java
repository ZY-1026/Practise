package leetCode.letcode724;

public class Solution {
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length <= 2) return -1;
        int sum = 0, leftSum = 0;
        for (int num : nums) {
            sum += num;
        }
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == sum - nums[i] - leftSum) return i;
            leftSum += nums[i];
        }
        return -1;
    }
}
