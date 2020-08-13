package sort.insertSort;

public class InsertSort {

    private static void insertSort(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 0, -1};
        insertSort(arr, arr.length);
        for (int a : arr) {
            System.out.println(a);
        }
    }
}
