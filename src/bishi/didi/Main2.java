package didi;

import java.util.Scanner;

public class Main2 {

    private static void bl(long[][] nums, int x, int y, long a, long b, int step) {
        while (true) {
            for (int index = 0; index < step; index++) {
                y--;
                nums[x][y] = a + b;
                if (x == 0 && y == 0) return;
                a = b;
                b = nums[x][y];
            }
            for (int index = 0; index < step; index++) {
                x++;
                nums[x][y] = a + b;
                if (x == 0 && y == 0) return;
                a = b;
                b = nums[x][y];
            }
            step++;
            for (int index = 0; index < step; index++) {
                y++;
                nums[x][y] = a + b;
                if (x == 0 && y == 0) return;
                a = b;
                b = nums[x][y];
            }
            for (int index = 0; index < step; index++) {
                x--;
                nums[x][y] = a + b;
                if (x == 0 && y == 0) return;
                a = b;
                b = nums[x][y];
            }
            step++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        if (n <= 0) {
            sc.close();
            return;
        }
        long[][] nums = new long[n][n];
        if (n % 2 == 0) {
            nums[n / 2][n / 2 - 1] = 1;
            nums[n / 2][n / 2] = 1;
            nums[n / 2 - 1][n / 2] = 2;
            bl(nums, n / 2 - 1, n / 2, 1, 2, 2);
        } else {
            nums[n / 2][n / 2] = 1;
            if (n != 1) bl(nums, n / 2, n / 2, 0, 1, 1);
        }
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                System.out.print(nums[x][y]);
                if (y != n - 1) System.out.print(" ");
                else System.out.print("\n");
            }
        }
        sc.close();
    }
}
