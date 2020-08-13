package sort.selectSort;

public class SelectSort {

    private static void SelectSort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (i != min) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {-3, 0, 2, 4, 9, -1, -2};
        SelectSort(arr);
        for (int a : arr) {
            System.out.println(a);
        }
    }
}
