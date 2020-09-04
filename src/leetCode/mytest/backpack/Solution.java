package leetCode.mytest.backpack;


import java.util.LinkedHashMap;

/**
 * 问题描述：0-1背包问题
 * （1）不放第nn个物品，此时总价值为F(n−1,C)
 * （2）放置第nn个物品，此时总价值为Vn + F(n-1, C - Wn)
 * <p>
 * 因此：F(i,C)=max(F(i−1,C),v(i)+F(i−1,C−w(i)))
 */

public class Solution {
    /**
     * 递归方法求解0-1背包问题
     *
     * @param w        物品的重量数组
     * @param v        物品的价值数组
     * @param index    当前待选择的物品索引
     * @param capacity 当前背包有效容量
     * @return
     */
    private static int solveKS(int[] w, int[] v, int index, int capacity) {
        if (index < 0 || capacity <= 0) return 0;
        // 不放第index个物品所得的价值
        int res = solveKS(w, v, index - 1, capacity);
        //放第index个物品所得价值（前提是：第index个物品可以放得下）
        if (w[index] <= capacity) {
            res = Math.max(res, v[index] + solveKS(w, v, index - 1, capacity - w[index]));
        }
        return res;
    }

    /**
     * 利用动态规划解决0-1背包问题
     *
     * @param w 物品的重量数组
     * @param v 物品的价值数组
     * @param C 背包所能容纳的容量
     * @return
     */
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

    public static int KnapSack(int[] w, int[] v, int C) {
        int size = w.length;
        return solveKS(w, v, size - 1, C);
    }

    public static void main(String[] args) {
//        int[] w = {2, 1, 3, 2};
//        int[] v = {12, 10, 20, 15};
//        System.out.println(KnapSack(w, v, 5));
        LinkedHashMap<String, String> hashMap = new LinkedHashMap<>();
        hashMap.put("name1", "josan1");
        hashMap.put("name2", "josan2");
        hashMap.put("name3", "josan3");
        for (String key : hashMap.keySet()) {
            System.out.println(hashMap.get(key));
        }
    }
}