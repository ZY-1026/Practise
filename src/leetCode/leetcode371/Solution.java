package leetCode.letcode371;

public class Solution {
    public int getSum(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        // 异或
        int low;
        int carrier;
        while (true) {
            low = a ^ b;
            carrier = (a & b);
            if (carrier == 0) break;
            a = low;
            b = carrier << 1;
        }
        return low;
    }

}
