package leetCode.letcode18;

import java.util.*;

public class Solution {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int high = nums.length - 1;
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[0] > target / 4) break;
            for (int j = i + 1; j < nums.length; j++) {
                int low = j + 1;
                int result = target - nums[i] - nums[j];
                while (low < high) {
                    if (nums[low] + nums[high] == result) {
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[low], nums[high]);
                        lists.add(list);
                        while (low < high && nums[low] == nums[low + 1]) low++;
                        while (low < high && nums[high] == nums[high - 1]) high--;
                        low++;
                        high--;
                    }//end-if
                    else if (nums[low] + nums[high] < result) {
                        while (low < high && nums[low] == nums[low + 1]) low++;
                        low++;
                    } else {
                        while (low < high && nums[high] == nums[high - 1]) high--;
                        high--;
                    }
                }//end-while
            }//end-for
        }//end-for
        return lists;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> lists = fourSum(nums, target);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.println(i);
            }
        }
    }
}
