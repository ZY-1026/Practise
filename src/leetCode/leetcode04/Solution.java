package leetCode.leetcode04;

import java.util.Arrays;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] tmp = new int[m + n];
        int index = 0;
        for (int i = 0; i < m; i++) {
            tmp[index++] = nums1[i];
        }

        for (int i = 0; i < n; i++) {
            tmp[index++] = nums2[i];
        }
        Arrays.sort(tmp);
        return (m + n) % 2 == 0 ? (tmp[(m + n) / 2] + tmp[(m + n) / 2 - 1]) / 2.0 : tmp[(m + n) / 2];
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return 0.0;
    }

    private static int findK(int[] nums, int low, int high, int k) {
        if (k > nums.length) return -1;
        int i = low, j = high;
        int tmp;
        if (low < high) {
            tmp = nums[i];
            while (i != j) {
                while (i != j && nums[j] >= tmp) j--;
                nums[i] = nums[j];
                while (i != j && nums[i] <= tmp) i++;
                nums[j] = nums[i];
            }//while
            nums[i] = tmp;
            if (k - 1 == i) return nums[i];
            else if (k - 1 < i) return findK(nums, low, i - 1, k);
            else return findK(nums, i + 1, high, k);
        } // if
        else if (low == high && low == high - 1) {
            return nums[k - 1];
        }
        return -1;
    }
}
