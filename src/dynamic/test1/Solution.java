package dynamic.test1;

/**
 * 数组最大不连续递增子序列
 */

public class Solution {
    private static int MaxChildArrayOrder(int a[]) {
        int n = a.length;
        int tmp[] = new int[n]; // tmp[i]代表0....i上最长递增子序列
        for (int i = 0; i < n; i++) {
            tmp[i] = 1; // //初始值都为1
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j] && tmp[j] + 1 > tmp[i]) {
                    tmp[i] = tmp[j] + 1;
                }
            }
        }
        int max = 0;
        // 找tmp数组中最大值
        for (int i = 1; i < n; i++) {
            if (tmp[i] > max) {
                max = tmp[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {5, 6, 1, 3, 9, 10, 11, 12};
        System.out.println(MaxChildArrayOrder(a));
    }
}
