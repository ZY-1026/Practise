package leetCode.letcode867;

public class Solution {
    public int[][] transpose(int[][] A) {
        if (A == null || A[0].length == 0 || A.length == 0) return null;
        int row = A.length, col = A[0].length;
        int[][] ans = new int[col][row];
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++) {
               ans[j][i] = A[i][j];
            }
        return ans;
    }
}
