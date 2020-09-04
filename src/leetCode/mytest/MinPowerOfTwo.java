package leetCode.mytest;

// 找大于等于某数的最小的2的n次幂
public class MinPowerOfTwo {
    private static int min_power_two(int x) {
//        int res = 1;
//        while (res < x) {
//            res = res << 1;
//        }
//        return res;
        x = x - 1;
        x |= x >>> 1;
        x |= x >>> 2;
        x |= x >>> 4;
        x |= x >>> 8;
        x |= x >>> 16;
        return (x < 0) ? 1 : (x >= Integer.MAX_VALUE ? Integer.MAX_VALUE : x + 1);
    }

    public static void main(String[] args) {
        System.out.println(min_power_two(-1));
    }
}
