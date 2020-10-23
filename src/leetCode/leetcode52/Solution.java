package leetCode.leetcode52;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int totalNQueens(int n) {
        List<List<String>> lists = solveNQueens(n);
        return lists.size();
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> lists = new ArrayList<>();
        int[] queue = new int[n + 1];
        queue(n, queue, lists);
        return lists;
    }

    private boolean place(int i, int[] queue) {
        int j = 1;
        if (i == 1) return true;
        while (j < i) { // k = 1~i-1是已经放置了皇后的行
            if ((queue[j] == queue[i]) || (Math.abs(queue[j] - queue[i]) == Math.abs(j - i))) return false;
            j++;
        }
        return true;
    }

    /**
     * 回溯法求解
     *
     * @param n
     * @param q
     * @param lists
     */
    private void queue(int n, int[] q, List<List<String>> lists) {
        int i = 1;
        q[i] = 0;
        while (i >= 1) {
            q[i]++;
            while (q[i] <= n && !place(i, q)) q[i]++;
            if (q[i] <= n) {
                if (i == n) {
                    List<String> list = new ArrayList<>();
                    for (int j = 1; j <= n; j++) {
                        char[] tmp = new char[n];
                        Arrays.fill(tmp, '.');
                        int index = q[j];
                        tmp[index - 1] = 'Q';
                        list.add(String.valueOf(tmp));
                    }
                    lists.add(new ArrayList<>(list));
                } else {
                    i++;
                    q[i] = 0;
                }
            } else {
                i--;
            }
        }
    }
}
