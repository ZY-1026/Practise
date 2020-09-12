package leetCode.interview0812;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。这里的“对角线”指的是所有的对角线，不只是平分整个棋盘的那两条对角线
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/eight-queens-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> lists = new ArrayList<>();
        int[] queue = new int[n + 1];
        queen(1, n, queue, lists);
        //queue(n, queue, lists);
        return lists;
    }

    /**
     * 测试(i,j)位置能否放置皇后
     *
     * @param i
     * @param j
     * @return
     */
    private boolean place(int i, int j, int[] queue) {
        if (i == 1) return true;
        int k = 1;
        while (k < i) { // k = 1~i-1是已经放置了皇后的行
            if ((queue[k] == j) || (Math.abs(queue[k] - j) == Math.abs(i - k))) return false;
            k++;
        }
        return true;
    }

    /**
     * 递归求解
     *
     * @param i
     * @param n
     * @param q
     * @param lists
     */
    private void queen(int i, int n, int[] q, List<List<String>> lists) {
        if (i > n) {
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
            for (int j = 1; j <= n; j++) {
                if (place(i, j, q)) {
                    q[i] = j;
                    queen(i + 1, n, q, lists);
                }
            }
        }
    }
}
