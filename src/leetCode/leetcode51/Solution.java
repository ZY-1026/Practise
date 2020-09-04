package leetCode.letcode51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> lists = new ArrayList<>();
        int[] queue = new int[n + 1];
        //queen(1, n, queue, lists);
        queue(n, queue, lists);
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
            } else i--;
        }
    }

    public static void main(String[] args) {
        List<List<String>> lists = new Solution().solveNQueens(20);
        for (int i = 0; i < lists.size(); i++) {
            List<String> tmp = lists.get(i);
            for (int j = 0; j < tmp.size(); j++) {
                System.out.print("[" + tmp.get(j) + "]");
            }
            System.out.println();
        }
        System.out.println(lists.size());
    }
}
