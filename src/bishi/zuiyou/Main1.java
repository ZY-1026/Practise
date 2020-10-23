package bishi.zuiyou;

import java.util.Arrays;

public class Main1 {
    public int[] getTriggerTime(int[][] increase, int[][] requirements) {
        // write code here
        int n = requirements.length, m = increase.length;
        int[] cs = new int[m + 1];
        int[] rs = new int[m + 1];
        int[] hs = new int[m + 1];
        prepare(cs, rs, hs, increase);
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            doResult(res, i, cs, requirements[i][0], m + 1);
            doResult(res, i, rs, requirements[i][1], m + 1);
            doResult(res, i, hs, requirements[i][2], m + 1);
        }
        return res;
    }

    private void prepare(int[] cs, int[] rs, int[] hs, int[][] increase) {
        int c = 0, r = 0, h = 0;
        for (int i = 0; i < cs.length - 1; i++) {
            c += increase[i][0];
            r += increase[i][1];
            h += increase[i][2];
            cs[i + 1] = c;
            rs[i + 1] = r;
            hs[i + 1] = h;
        }
    }

    private void doResult(int[] res, int i, int[] s, int target, int arrLength) {
        if (res[i] == -1) return;
        int tmp = search(s, target);
        if (tmp == arrLength) {
            res[i] = -1;
            return;
        }
        res[i] = Math.max(res[i], tmp);
    }

    private int search(int[] nums, int target) {
        int tmp = Arrays.binarySearch(nums, target);
        if (tmp < 0) return 0 - tmp - 1;
        for (int i = tmp; i >= 0; i--) {
            if (nums[i] != nums[tmp]) {
                return i + 1;
            }
        }
        return 0;
    }
}
