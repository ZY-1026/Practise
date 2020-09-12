package leetCode.leetcode1020;

public class Solution {
    public int numEnclaves(int[][] A) {
        int row = A.length, col = A[0].length;
        for (int i = 0; i < row; i++) {
            dfs(A, i, 0);
            dfs(A, i, col - 1);
        }
        for (int i = 0; i < col; i++) {
            dfs(A, 0, i);
            dfs(A, row - 1, i);
        }
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (A[i][j] == 1) count++;
            }
        }
        return count;
    }

    public void dfs(int[][] A, int i, int j) {
        if (A == null || A.length == 0) return;
        int row = A.length, col = A[0].length;
        if (i < 0 || j < 0 || i >= row || j >= col) return;
        if (A[i][j] == 0) return;
        A[i][j] = 0;
        if (i > 0) dfs(A, i - 1, j);
        if (j > 0) dfs(A, i, j - 1);
        if (i < row - 1) dfs(A, i + 1, j);
        if (j < col - 1) dfs(A, i, j + 1);
    }
}
