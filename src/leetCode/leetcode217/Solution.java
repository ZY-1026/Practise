package leetCode.letcode217;

import java.util.HashSet;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return true;
        if (nums.length == 1) return true;
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (hashSet.contains(nums[i])) return true;
            else {
                hashSet.add(nums[i]);
            }
        }
        return false;
    }
}
