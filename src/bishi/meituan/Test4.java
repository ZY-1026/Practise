package bishi.meituan;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m, a, b;
        m = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();
        int[][] dp = new int[a + 1][b + 1];
        for (int index = 0; index < m; index++) {
            int va = sc.nextInt();
            int vb = sc.nextInt();
            for (int cura = a; cura >= 0; cura--) {
                for (int curb = b; curb >= 0; curb--) {
                    if (cura > 0) dp[cura][curb] = Math.max(dp[cura][curb], dp[cura - 1][curb] + va);
                    if (curb > 0) dp[cura][curb] = Math.max(dp[cura][curb], dp[cura][curb - 1] + vb);
                }
            }
        }
        System.out.println(dp[a][b]);
        sc.close();
    }
}
