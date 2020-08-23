package bishi.guanglianda;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int C = input.nextInt() * 100;

        float[] c = new float[n];
        int[] w = new int[n];
        int[] tmp = new int[n];

        for (int i = 0; i < n; i++) {
            c[i] = input.nextFloat();
            w[i] = input.nextInt();
            tmp[i] = (int) (c[i] * 100);
        }

        int[] dp = new int[C + 1];
        for (int i = 0; i < n; i++)
            for (int j = C; j >= tmp[i]; j--)
                dp[j] = Math.max(dp[j - tmp[i]] + w [i], dp[j]);

        System.out.println(dp[C]);
    }
}
