package leetCode.letcode33;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0 || nums == null) return -1;
        // 寻找在何处发生了旋转
        int index;
        for (index = 0; index < nums.length - 1; index++) {
            if (nums[index + 1] < nums[index]) break;
        }// for

        // 对前半部分进行二分查找
        int m = binarySearch(nums, 0, index, target);
        int n = binarySearch(nums, index + 1, nums.length - 1, target);
        return m == -1 ? n : m;
    }

    private static int binarySearch(int[] nums, int low, int high, int target) {
        if (low > high) return -1;
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) high = mid - 1;
            if (nums[mid] < target) low = mid + 1;
        }
        return -1;
    }
}
