package sort.mergeSort;

public class Solution {

    // 合并两个有序数组
    public static void merge(int[] a, int low, int mid, int high) {
        int[] b = new int[a.length];
        int i = low, j = mid + 1, k = 0;
        while (i <= mid && j <= high) {
            if (a[i] <= a[j]) {
                b[k] = a[i];
                k++;
                i++;
            } else {
                b[k] = a[j];
                k++;
                j++;
            }
        }

        while (i <= mid) {
            b[k] = a[i];
            k++;
            i++;
        }
        while (j <= high) {
            b[k] = a[j];
            k++;
            j++;
        }
    }
}
