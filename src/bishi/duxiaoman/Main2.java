package bishi.duxiaoman;

public class Main2 {
    private void dfs(char[][] maze, boolean[][] visited, int[] start, int[] des, int[] res, int K, int k2) {
        int row = start[0], col = start[1];
        if (row == des[0] && col == des[1]) {
            res[0] = Math.min(res[0], K);
            return;
        }
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < 4; i++) {
            int x = row, y = col;
            x += dirs[i][0];
            y += dirs[i][1];
            if (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] != '1' && !visited[x][y]) {
                visited[row][col] = true;
                if (maze[x][y] == '#') dfs(maze, visited, new int[]{x, y}, des, res, K + k2 + 1, k2);
                else dfs(maze, visited, new int[]{x, y}, des, res, K + 1, k2);
                visited[row][col] = false;
            }
        }
    }

    public static void main(String[] args) {
        char[][] maze = {{'0', '#', '0'}, {'#', '#', '1'}, {'0', '0', '0'}};
        int[] res = new int[]{Integer.MAX_VALUE};
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        new Main2().dfs(maze, visited, new int[]{0, 0}, new int[]{maze.length - 1, maze[0].length - 1}, res, 0, 2);
        System.out.println(res[0]);
    }
}
