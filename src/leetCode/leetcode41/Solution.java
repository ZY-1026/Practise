package leetCode.letcode41;

import java.util.*;

public class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 1 && nums[0] == 1) return 2;
        // 找出所有的正整数
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num > 0) set.add(num);
        }
        List<Integer> list = new ArrayList<>(set);
        // 如果set中仅仅含有一个元素
        if (set.size() == 1) {
            // set中的一个元素为1
            if (set.contains(1)) return 2;
                // set中的一个元素不为1
            else return 1;
        }
        if (!set.contains(1)) return 1;
        Collections.sort(list);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i + 1) - list.get(i) != 1) return list.get(i) + 1;
            else continue;
        }
        return list.get(list.size() - 1) + 1;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 4, 2, 1, 9, 10};
        System.out.println(new Solution().firstMissingPositive(nums));
    }
}
