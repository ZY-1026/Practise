package leetCode.mytest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

// 一个排好序的数组，找出两数之和为m的所有组合
public class TwoNumSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-3, -2, -1, 0, 1, 2, 3};
        List<List<Integer>> lists = helper(nums, 0);
//        for (List<Integer> list : lists) {
////            for (int i = 0; i < list.size(); i++) {
////                System.out.println(list.get(i));
////            }
////        }
        System.out.println(lists.size());
    }

    public static List<List<Integer>> helper(int[] nums, int num) {
        if (nums == null || nums.length == 0) return null;
        if (nums[0] > num) return null;
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int target = num - nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == num) continue;
                if (nums[j] == target) {
                    lists.add(Arrays.asList(nums[i], nums[j]));
                }
            }
        }
        return lists;
    }
}
