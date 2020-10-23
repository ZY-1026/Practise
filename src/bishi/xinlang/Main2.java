package bishi.xinlang;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        char[] chars = string.toCharArray();
        System.out.println(isUnique(chars));
        sc.close();
    }


    public static boolean isUnique(char[] chars) {
        if (chars == null) return true;
        heapSort(chars);
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                return false;
            }
        }
        return true;
    }

    // 堆排序
    private static void heapSort(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            heapInsert(chars, i);
        }
        for (int i = chars.length - 1; i > 0; i--) {
            heapify(chars, 0, i);
        }
    }

    private static void heapify(char[] chars, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && chars[left] < chars[left + 1] ? left + 1 : left;
            largest = chars[index] > chars[largest] ? index : largest;
            if (largest == index) break;
            swap(chars, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    private static void heapInsert(char[] chars, int index) {
        while (chars[index] > chars[(index - 1) / 2]) {
            swap(chars, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
