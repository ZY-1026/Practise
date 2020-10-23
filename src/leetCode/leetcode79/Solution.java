package leetCode.leetcode79;

public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) return false;
        int[][] visited = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = 1;
                    if (dfs(board, word, 1, i, j, visited)) return true;
                    visited[i][j] = 0;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int i, int j, int[][] visited) {
        if (index == word.length()) return true;
        if (i > 0 && visited[i - 1][j] == 0 && board[i - 1][j] == word.charAt(index)) {
            visited[i - 1][j] = 1;
            if (dfs(board, word, index + 1, i - 1, j, visited)) return true;
            visited[i - 1][j] = 0;
        }

        if (i < board.length - 1 && visited[i + 1][j] == 0 && board[i + 1][j] == word.charAt(index)) {
            visited[i + 1][j] = 1;
            if (dfs(board, word, index + 1, i + 1, j, visited)) return true;
            visited[i + 1][j] = 0;
        }

        if (j > 0 && visited[i][j - 1] == 0 && board[i][j - 1] == word.charAt(index)) {
            visited[i][j - 1] = 1;
            if (dfs(board, word, index + 1, i, j - 1, visited)) return true;
            visited[i][j - 1] = 0;
        }

        if (j < board[0].length - 1 && visited[i][j + 1] == 0 && board[i][j + 1] == word.charAt(index)) {
            visited[i][j + 1] = 1;
            if (dfs(board, word, index + 1, i, j + 1, visited)) return true;
            visited[i][j + 1] = 0;
        }
        return false;
    }
}
