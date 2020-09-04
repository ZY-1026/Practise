package offer.test20;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，
 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution {
    public boolean isNumber(String s) {
        boolean result = true;
        try {
            Double.valueOf(s);
        } catch (Exception e) {
            result = false;
        }

        if (result && (s.indexOf("f") != -1) || s.indexOf("F") != -1 || s.indexOf("d") != -1 || s.indexOf("D") != -1) {
            return false;
        }
        return result;
    }
}
