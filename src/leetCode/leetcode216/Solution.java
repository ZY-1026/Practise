package leetCode.leetcode216;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), k, n, 1);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> path, int k, int n, int start) {
        if (path.size() == k && n == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= 9; i++) {
            path.add(i);
            dfs(res, path, k, n - i, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
