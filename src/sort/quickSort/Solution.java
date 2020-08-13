package sort.quickSort;

public class Solution {

    public static int partition(int[] array, int low, int high) {
        int i = low;
        int j = high;
        int tmp = array[i]; //将第一个元素作为基准
        while (i < j) {
            //右侧扫描
            while (i < j && array[j] >= tmp) {
                j--;
            }
            array[i] = array[j];

            while (i < j && array[i] <= tmp) {
                i++;
            }
            array[j] = array[i];
        }
        array[i] = tmp;
        return i;
    }

    public void quickSort(int[] array, int i, int j) {
        int index;
        if (i < j) {
            index = partition(array, i, j);
            quickSort(array, i, index - 1);
            quickSort(array, index + 1, j);
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 3, 2, 1, -1};
        new Solution().quickSort(arr, 0, arr.length - 1);
        for (int a : arr) {
            System.out.println(a);
        }
    }
}
