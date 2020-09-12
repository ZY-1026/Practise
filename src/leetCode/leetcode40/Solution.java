package leetCode.leetcode40;

import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        dfs(candidates, 0, target, new LinkedList<>(), res);
        return res;
    }

    private void dfs(int[] candidates, int index, int target, List<Integer> path, List<List<Integer>> res) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            // 去重
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            path.add(candidates[i]);
            dfs(candidates, i + 1, target - candidates[i], path, res);
            path.remove(path.size() - 1);
        }
    }
}
