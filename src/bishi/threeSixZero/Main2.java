package bishi.threeSixZero;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int res = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            int temp1 = scanner.nextInt();
            int temp2 = scanner.nextInt();
            if (temp2 == 0) {
                res += temp1;
            } else {
                arr[index++] = temp1;
            }

        }
        Arrays.sort(arr);

        for (int i = n - 1; i >= n - index; i--) {
            res = Math.max(res * 2, res + arr[i]);
        }
        System.out.print(res);
    }
}

