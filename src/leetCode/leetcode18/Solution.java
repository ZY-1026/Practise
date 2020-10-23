package leetCode.leetcode18;

import java.util.*;

public class Solution {
    public List<List<Integer>> result = new ArrayList<>();
//    public static List<List<Integer>> fourSum(int[] nums, int target) {
//        int high = nums.length - 1;
//        List<List<Integer>> lists = new ArrayList<>();
//        Arrays.sort(nums);
//        if (nums[0] > target / 4) return lists;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                int low = j + 1;
//                int result = target - nums[i] - nums[j];
//                while (low < high) {
//                    if (nums[low] + nums[high] == result) {
//                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[low], nums[high]);
//                        lists.add(list);
//                        while (low < high && nums[low] == nums[low + 1]) low++;
//                        while (low < high && nums[high] == nums[high - 1]) high--;
//                        low++;
//                        high--;
//                    }//end-if
//                    else if (nums[low] + nums[high] < result) {
//                        while (low < high && nums[low] == nums[low + 1]) low++;
//                        low++;
//                    } else if (nums[low] + nums[high] > result) {
//                        while (low < high && nums[high] == nums[high - 1]) high--;
//                        high--;
//                    }
//                }//end-while
//            }//end-for
//        }//end-for
//        return lists;
//    }

    private void twoSum(int[] nums, int target, int a, int b) {
        int left = b + 1, right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                left++;
            } else if (nums[left] + nums[right] > target) {
                right--;
            } else {
                List<Integer> res = new ArrayList<>();
                res.add(nums[a]);
                res.add(nums[b]);
                res.add(nums[left]);
                res.add(nums[right]);
                result.add(new ArrayList<>(res));
                while (left < right && nums[left + 1] == nums[left]) left++;
                while (left < right && nums[right] == nums[right - 1]) right--;
                left++;
                right--;
            }
        }
    }

    private void threeSum(int[] nums, int target, int a) {
        for (int i = a + 1; i < nums.length; i++) {
            if (i > a + 1 && nums[i] == nums[i - 1]) continue;
            twoSum(nums, target - nums[i], a, i);
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++i) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            threeSum(nums, target - nums[i], i);
        }
        return result;
    }
}

