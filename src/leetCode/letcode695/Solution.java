package leetCode.letcode695;

public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 || grid == null) return 0;
        int rows = grid.length, col = grid[0].length;
        int res = 0;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, dfs(grid, i, j));
                }
            }
        return res;
    }

    public int dfs(int[][] grid, int i, int j) {
        int row = grid.length, col = grid[0].length;
        if (i < 0 || j < 0 || i >= row || j >= col) return 0;
        if (grid[i][j] == 0) return 0;
        grid[i][j] = 0;
        int count = 1;
        count += dfs(grid, i + 1, j);
        count += dfs(grid, i - 1, j);
        count += dfs(grid, i, j + 1);
        count += dfs(grid, i, j - 1);
        return count;
    }
}
