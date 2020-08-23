package leetCode.letcode34;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int[] result = new int[2];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) list.add(i);
        }
        int size = list.size();
        if (size == 0) {
            result[0] = -1;
            result[1] = -1;
        } else {
            result[0] = list.get(0);
            result[1] = list.get(size - 1);
        }
        return result;
    }
}
