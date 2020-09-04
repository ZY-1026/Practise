package leetCode.letcode135;

import java.util.Arrays;

public class Solution {
    public int candy(int[] ratings) {
        int res = ratings.length;
        int[] tmp = new int[res];
        Arrays.fill(tmp, 0);
        for (int i = 1; i < res; i++) {
            if (ratings[i] > ratings[i - 1])
                tmp[i] = tmp[i - 1] + 1;
        }
        for (int i = res - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i] && tmp[i - 1] < tmp[i] + 1)
                tmp[i - 1] = tmp[i] + 1;
        }
        for (int i = 0; i < ratings.length; i++)
            res += tmp[i];
        return res;
    }
}
