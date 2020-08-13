package leetCode.letcode905;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int[] sortArrayByParity(int[] A) {
//        Integer[] B = new Integer[A.length];
//        for (int t = 0; t < A.length; t++) {
//            B[t] = A[t];
//        }
//        Arrays.sort(B, (a, b) -> Integer.compare(a % 2, b % 2));
//        //Arrays.sort(B, Comparator.comparingInt(a -> a % 2));
//        for (int t = 0; t < A.length; t++) {
//            A[t] = B[t];
//        }
//        return A;
        int i = 0, j = A.length - 1;
        while (i < j) {
            if (A[i] % 2 > A[j] % 2) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
            if (A[i] % 2 == 0) i++;
            if (A[j] % 2 == 1) j--;
        }
        return A;
    }
}
