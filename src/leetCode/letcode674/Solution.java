package leetCode.letcode674;

public class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int result = 0;
        int point = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] >= nums[i]) point = i;
            result = Math.max(result, i - point + 1);
        }
        return result;
    }

    public int findLengthOfLCIS1(int[] nums) {
        if (nums == null) return 0;
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int length = 1;
        int ans = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1])
                length++;
            else
                length = 1;
            ans = length > ans ? length : ans;
        }
        return ans;
    }
}
