package test;

import java.util.HashMap;

// 和谐子序列
public class Test01 {
    public int helper(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        if (nums.length == 2 && Math.abs(nums[0] - nums[1]) == 1) return 2;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for (int key : hashMap.keySet()) {
            if (hashMap.containsKey(key + 1)) {
                res = Math.max(res, hashMap.get(key) + hashMap.get(key + 1));
            }
        }
        return res;
    }
}
