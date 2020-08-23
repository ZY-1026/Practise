package leetCode.letcode67;

public class Solution {
    public String addBinary(String a, String b) {
        return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
    }

    public String addBinary1(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; i++) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            stringBuilder.append((char) (carry % 2 + '0'));
            carry /= 2;
        }
        if (carry > 0) stringBuilder.append('1');
        return stringBuilder.reverse().toString();
    }
}
