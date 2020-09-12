package leetCode.leetcode39;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return null;
        dfs(candidates, 0, target, new ArrayList<>());
        return res;
    }

    private void dfs(int[] candidates, int index, int target, List<Integer> path) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);
            // 元素可以重复使用，所以还是从i开始搜索
            dfs(candidates, i, target - candidates[i], path);
            // 回溯
            path.remove(path.size() - 1);
        }
    }
}
