package bishi.fiveEight;

public class Solution2 {
    public int question(int a, int b) {
        // write code here
        int result = 0;
        for (int i = 0; i <= 500; i++) {
            int k = i;
            boolean one = isSqrt(k + a);
            boolean two = isSqrt(k + b);
            if (one && two) {
                result = k;
                break;
            }
        }
        return result;
    }

    public static boolean isSqrt(int num) {
        if (num < 2) return true;
        long left = 2, right = num / 2, x, guessSquared;
        while (left <= right) {
            x = left + (right - left) / 2;
            guessSquared = x * x;
            if (guessSquared == num) {
                return true;
            }
            if (guessSquared > num) {
                right = x - 1;
            } else {
                left = x + 1;
            }
        }
        return false;
    }

}
