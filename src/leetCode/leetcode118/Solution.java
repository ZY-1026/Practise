package leetCode.letcode118;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        if (numRows <= 0) return lists;
        int[][] arr = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            int[] tmp = arr[i];
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < tmp.length; j++) {
                if (tmp[j] != 0) {
                    list.add(tmp[j]);
                }
            }
            lists.add(new ArrayList<>(list));
        }
        return lists;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution().generate(5);
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> list = lists.get(i);
            for (int j = 0; j < list.size(); j++) {
                System.out.print("[" + list.get(j) + "]");
            }
            System.out.println();
        }
    }
}
