package leetCode.offer.offer56;

import java.util.HashMap;
import java.util.Map;

public class SolutionII {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if(entry.getValue()==1) return entry.getKey();
        }
        return Integer.MIN_VALUE;
    }
}
