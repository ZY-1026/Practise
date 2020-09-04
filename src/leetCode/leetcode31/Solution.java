package leetCode.letcode31;


// 对于任何一个降序序列，找不到下一个全排列
public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length == 0 || nums == null) return;
        // 从后往前扫描，找到第一个a[i] < a[i-1]的位置
        int i = nums.length - 2;
        // i记录第一个出现拐点的地方
        while (i >= 0 && nums[i + 1] <= nums[i]) i--;
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) j--;
            swap(nums, i, j);
        }
        reverse(nums, i + 1);

    }

    // 从index位置开始反转数组
    private static void reverse(int[] nums, int index) {
        int i = index, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
