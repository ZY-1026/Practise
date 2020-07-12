package leetCode.letcode07;


public class Solution {
    public int reverse(int x) {
        long ans = 0;
        while (x != 0) {
            int t = x % 10;
            ans = ans * 10 + t;
            x /= 10;
        }
        boolean bool = (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) ? true : false;
        return bool ? 0 : (int) ans;
    }
}
