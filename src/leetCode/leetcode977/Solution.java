package leetCode.leetcode977;

import java.util.Arrays;

public class Solution {
    public int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];
        if (A.length == 0 || A == null) return res;
        int index = 0;
        for (int i = 0; i < A.length; i++) {
            res[index++] = A[i] * A[i];
        }
        Arrays.sort(res);
        return res;
    }
}
