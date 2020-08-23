package sort.mergeSort;

public class Solution {

    // 合并两个有序数组
    private static void merge(int[] a, int low, int mid, int high) {
        int[] b = new int[a.length];
        int i = low, j = mid + 1, k = 0;
        while (i <= mid && j <= high) {
            if (a[i] <= a[j]) {
                b[k++] = a[i++];
            } else {
                b[k++] = a[j++];
            }
        }

        while (i <= mid) { // 左侧没有扫描完
            b[k++] = a[i++];
        }
        while (j <= high) { // 右侧没有扫描完
            b[k++] = a[j++];
        }

        for (k = 0, i = low; i <= high; k++, i++) {
            a[i] = b[k];
        }
    }

    public static void mergeSort(int[] arr, int low, int high) {
        int mid;
        if (low < high) {
            mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = {-7, -8, 2, 0, 1, -10, 3, 9};
        mergeSort(arr, 0, arr.length - 1);
        for (int a : arr) {
            System.out.println(a);
        }
    }
}
