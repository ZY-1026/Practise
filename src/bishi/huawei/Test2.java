package bishi.huawei;

import java.util.Scanner;

public class Test2 {
    private static long helper(int target, int[] nums) {
        long[] dp = new long[target + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int x = num; x < target + 1; ++x) {
                dp[x] += dp[x - num];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        int target = Integer.valueOf(strings[0]);
        int[] nums = new int[strings.length - 1];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.valueOf(strings[i + 1]);
        }
        System.out.println(helper(target, nums));
    }
}