package sort.bubbleSort;

public class BubbleSort {
    private static void bubbleSort(int[] arr, int n) {
        for (int i = 0; i < n; i++) // 进行n趟排序
            for (int j = 0; j < n - i; j++) {
                if (arr[j] > arr[j + 1]) { // 下沉元素
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 0, -1};
        bubbleSort(arr, arr.length - 1);
        for (int a : arr) {
            System.out.println(a);
        }
    }
}
