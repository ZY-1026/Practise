package bishi.huawei;

import java.util.Scanner;

public class Test5 {
    private static void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == 'H') return;
        grid[r][c] = 'H';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public static int nums(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int nr = grid.length;
        int nc = grid[0].length;
        int num = 0;
        for (int r = 0; r < nr; r++)
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == 'S') {
                    num++;
                    dfs(grid, r, c);
                }
            }
        return num;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] numsTmp = sc.nextLine().split(",");
        int r = Integer.valueOf(numsTmp[0]);
        int c = Integer.valueOf(numsTmp[1]);
        char[][] grid = new char[r][c];
        for (int i = 0; i < r; i++) {
            grid[i] = sc.nextLine().toCharArray();
        }
        System.out.println(nums(grid));
        sc.close();
    }
}
