package offer.test12;

import java.util.concurrent.Callable;

public class Solution {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] matrix, char[] word, int i, int j, int k) {
        if (i >= matrix.length || i < 0 || j >= matrix[0].length || j < 0 || matrix[i][j] != word[k]) return false;
        if (k == word.length - 1) return true;
        char tmp = matrix[i][j];
        matrix[i][j] = '/';
        boolean res = dfs(matrix, word, i + 1, j, k + 1) || dfs(matrix, word, i - 1, j, k + 1) ||
                dfs(matrix, word, i, j + 1, k + 1) || dfs(matrix, word, i, j - 1, k + 1);
        matrix[i][j] = tmp;
        return res;
    }
}
