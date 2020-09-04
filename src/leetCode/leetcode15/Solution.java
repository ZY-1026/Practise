package leetCode.leetcode15;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 将数组从小到大排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if ((i > 0) && (nums[i] == nums[i - 1])) continue;
            int j = nums.length - 1;
            int target = 0 - nums[i];
            int k = i + 1;
            while (k < j) {
                if (nums[k] + nums[j] == target) {
                    List<Integer> item = Arrays.asList(nums[i], nums[j], nums[k]);
                    result.add(item);
                    // 判断前后两个值是否相同，相同的话移动指针
                    while (k < j && nums[k] == nums[k + 1]) k++;
                    while (k < j && nums[j] == nums[j - 1]) j--;
                    k++;
                    j--;
                } else if (nums[k] + nums[j] < target) {
                    k++;
                } else {
                    j--;
                }
            }//while
        }//for
        return result;
    }
}
