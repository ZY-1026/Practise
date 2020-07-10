package dynamic.maxString;

/**
 * 求解字符串中最长的数字串的长度
 */

public class Solution {

    public static int solve(String s) {
        int result = 0;
        int currentLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                currentLen++;
            } else {
                currentLen = 0;
            }
            result = result > currentLen ? result : currentLen;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "0001sssss02845075ss";
        System.out.println(solve(s));
    }
}
