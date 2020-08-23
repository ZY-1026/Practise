package bishi.jd;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int i = 1;
        double sum = 0.0;
        double j;
        while (i <= 2 * m) {
            if (i % 2 == 0) {
                j = -1.0 / i;
            } else {
                j = 1.0 / i;
            }
            sum = sum + j;
            i++;
        }
        System.out.printf("%.4f", 0.2 * sum);
        sc.close();
    }
}