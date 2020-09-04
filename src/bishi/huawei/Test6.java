package bishi.huawei;


import java.util.Scanner;

public class Test6 {
    private static int solveKS(int[] w, int[] v, int C) {
        int size = w.length;
        if (size == 0) return 0;
        int[][] dp = new int[size][C + 1];
        // 初始化第一行 仅考虑容量为C的背包放第0个物品的情况
        for (int i = 0; i <= C; i++)
            dp[0][i] = w[0] <= i ? v[0] : 0;
        for (int i = 1; i < size; i++)
            for (int j = 0; j <= C; j++) {
                dp[i][j] = dp[i - 1][j];
                if (w[i] <= j) {
                    dp[i][j] = Math.max(dp[i][j], v[i] + dp[i - 1][j - w[i]]);
                }
            }
        return dp[size - 1][C];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int capacity = sc.nextInt();
        sc.nextLine();
        int count = sc.nextInt();
        sc.nextLine();
        String[] tmpW = sc.nextLine().split(" ");
        String[] tmpV = sc.nextLine().split(" ");
        int[] w = new int[count];
        int[] v = new int[count];
        for (int i = 0; i < count; i++) {
            w[i] = Integer.valueOf(tmpW[i]);
            v[i] = Integer.valueOf(tmpV[i]);
        }
        System.out.println(solveKS(w, v, capacity));
        sc.close();
    }
}
