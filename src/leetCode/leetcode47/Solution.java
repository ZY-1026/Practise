package leetCode.letcode47;

import java.util.*;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> tmp = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }
        int n = nums.length;
        dfs(n, output, tmp, 0);
        Set<List<Integer>> set = new HashSet<>();
        for (List<Integer> list : tmp) {
            set.add(list);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> list : set) {
            res.add(new ArrayList<>(list));
        }
        return res;
    }

    /**
     * @param n      总长度
     * @param output 保存每次输出结果
     * @param res    保存所有输出结果
     * @param first  起始位置
     */
    private void dfs(int n, List<Integer> output, List<List<Integer>> res, int first) {
        if (first == n) {
            res.add(new ArrayList<>(output));
        }
        for (int i = first; i < n; i++) {
            Collections.swap(output, first, i);
            dfs(n, output, res, first + 1);
            Collections.swap(output, first, i);
        }
    }
}
