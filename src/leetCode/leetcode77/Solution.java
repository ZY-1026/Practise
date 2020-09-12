package leetCode.leetcode77;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n < k || k <= 0) return null;
        dfs(n, k, 1, new ArrayList<>());
        return res;
    }

    private void dfs(int n, int k, int index, List<Integer> path) {
        if (path.size() == k) {
            res.add(new ArrayList(path));
            return;
        } else {
            for (int i = index; i <= n + 1 - (k - path.size()); i++) {
                path.add(i);
                //System.out.println("递归之前 => " + path);
                dfs(n, k, i + 1, path);
                // 剪纸
                path.remove(path.size() - 1);
                //System.out.println("递归之后 => " + path);
            }
        }
    }

    public static void main(String[] args) {
        new Solution().combine(5,3);
    }
}
