package leetCode.offer.offer56;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionI {
    public int[] singleNumbers(int[] nums) {
        if (nums.length == 0 || nums == null) return null;
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() == 1) list.add(entry.getKey());
        }
        int size = list.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
