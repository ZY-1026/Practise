package recursive.test1;

/**
 * 递归求数组最大值
 */

public class Solution {
    public static int max(int[] a, int low, int high) {
        if (low == high) return a[low];
        if (high - low == 1) {
            return a[low] > a[high] ? a[low] : a[high];
        }
        int mid = (low + high) / 2;
        int max1 = max(a, low, mid);
        int max2 = max(a, mid + 1, high);
        return max1 > max2 ? max1 : max2;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 0, -1, 8, 9};
        System.out.println(max(a, 0, a.length - 1));
    }
}
