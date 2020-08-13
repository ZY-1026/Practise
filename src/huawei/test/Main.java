package huawei.test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int num = 1, max = 1;
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        int[] a = new int[strings.length - 1];
        int n = Integer.valueOf(strings[0]);
        for (int i = 1; i < strings.length; i++) {
            a[i - 1] = Integer.valueOf(strings[i]);
        }
        int[] tmp = new int[strings.length - 1];
        for (int i = 0; i < n; i++) {
            tmp[i] = a[i];
            for (int j = i + 1; j < n; j++) {
                tmp[j] = a[j];
                if (tmp[i] + 1 == tmp[j]) {
                    num += 1;
                    tmp[i] = tmp[j];
                }
            }
            if (num > max) {
                max = num;
            }
            num = 1;
        }
        System.out.println(n - max);
        scanner.close();
    }
}
