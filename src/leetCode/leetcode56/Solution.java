package leetCode.letcode56;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int[][] merge(int[][] intervals) {
       if (intervals.length==0) return new int[0][0];
       int[][] result = new int[intervals.length][2];
        Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));

        return null;
    }
}
