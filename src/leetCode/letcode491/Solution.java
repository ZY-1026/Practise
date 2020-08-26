package leetCode.letcode491;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(nums, -1, new ArrayList<>());
        return result;
    }

    private void dfs(int[] nums, int index, List<Integer> list) {
        if (list.size() > 1) {
            result.add(new ArrayList<>(list));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = index + 1; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            if (index == -1 || nums[i] >= nums[index]) {
                list.add(nums[i]);
                dfs(nums, i, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
