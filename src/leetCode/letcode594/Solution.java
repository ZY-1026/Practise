package leetCode.letcode594;

import java.util.*;

public class Solution {
    public int findLHS(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) return 0;
        if (nums.length == 2 && Math.abs(nums[0] - nums[1]) == 1) return 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()){
            if (map.containsKey(key + 1)){
                res = Math.max(res, map.get(key) + map.get(key + 1));
            }
        }
        return res;
    }
}
