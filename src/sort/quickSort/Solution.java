package sort.quickSort;

public class Solution {

    public static int partition(int[] array) {
        int i = 0;
        int j = array.length - 1;
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
            index = partition(array);
            quickSort(array, i, index);
            quickSort(array, index, j);
        }
    }
}
