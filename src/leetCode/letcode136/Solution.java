package leetCode.letcode136;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int singleNumber(int[] nums) {
//        if (nums == null || nums.length == 0) return 0;
//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        for (int num : nums) {
//            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
//        }
//        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
//            if (entry.getValue() == 1) {
//                return entry.getKey();
//            }
//        }
//        return -1;
        if (nums == null || nums.length == 0) return -1;
        int ans = 0;
        for (int num : nums){
            ans = ans ^ num;
        }
        return ans;
    }
}
