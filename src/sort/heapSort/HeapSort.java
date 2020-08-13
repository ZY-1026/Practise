package sort.heapSort;

public class HeapSort {

    // 大根堆
    private static void siftMaxHeap(int[] arr, int low, int high) {
        int i = low, j = i * 2;
        int tmp = arr[i];
        while (j < high) {
            if (j < high && arr[j] < arr[j + 1]) j++;
            if (tmp < arr[j]) {
                arr[i] = arr[j];
                i = j;
                j = 2 * i;
            } else break;
            arr[i] = tmp;
        }
    }

    // 小根堆
    private static void siftMinHeap(int[] arr, int low, int high) {
        int i = low, j = 2 * i + 1;
        int tmp = arr[i];
        while (j < high) {
            if (j+1 < high && arr[j] > arr[j + 1]) j++;
            if (tmp < arr[j]) break;
            else {
                arr[i] = arr[j];
                i = j;
                j = i * 2 + 1;
            }
            arr[i] = tmp;
        }
    }


    // 建立堆
    private static void createHeap(int[] arr, int n) {
        for (int i = n >> 1; i >= 0; i--) {
            //siftMaxHeap(arr, i, n);
            siftMinHeap(arr, i, n);
        }
    }

    public static void heapSort(int[] arr, int n) {
        createHeap(arr, n);
        for (int i = n; i > 0; i--) {
            // 交换堆顶和最后一个元素
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            siftMaxHeap(arr, 0, i - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, -1, 3, 8, 2, -9};
//        createHeap(arr, arr.length - 1);
//        for (int a : arr) {
//            System.out.println(a);
//        }
        createHeap(arr, arr.length);
        for(int num : arr){
            System.out.println(num);
        }
    }
}
