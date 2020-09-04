package leetCode.mytest.binarySearch;

public class Main {

    private static int index(int[] arr, int low, int high, int n) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (arr[mid] == n) {
            int index = index(arr, low, mid - 1, n);
            return index == -1 ? mid : index;
        } else {
            if (arr[mid] > n) {
                return index(arr, low, mid - 1, n);
            } else {
                return index(arr, mid + 1, high, n);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 3, 4, 5, 6};
        System.out.println(index(arr, 0, arr.length - 1, 3));
    }
}
