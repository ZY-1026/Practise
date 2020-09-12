package leetCode.offer.offer17;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] printNumbers(int n) {
        int len = (int) Math.pow(10, n);
        int[] res = new int[len - 1];
        for (int i = 0; i < len - 1; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}
