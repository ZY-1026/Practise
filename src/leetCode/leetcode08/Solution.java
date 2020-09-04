package leetCode.leetcode08;

import java.util.ArrayDeque;

public class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;
        str = str.replace(" ", "");
        if ((str.charAt(0) >= 'a' && str.charAt(0) <= 'z') || (str.charAt(0) >= 'A' && str.charAt(0) <= 'Z')) return 0;
        ArrayDeque<Character> queue = new ArrayDeque<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            queue.add(c);
        }
        while (queue.isEmpty() == false) {
            System.out.println(queue.poll());
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!queue.isEmpty()) {
            char tmp = queue.peek();
            if (Character.isDigit(tmp) || tmp == '-') {
                stringBuilder.append(tmp);
            }
            queue.poll();
        }
        System.out.println(stringBuilder.toString());
        String result = stringBuilder.toString();
        Long tmp = Math.abs(Long.valueOf(result));
        if (tmp > Integer.MAX_VALUE) {
            tmp = tmp >> 1;
        }
        return (int) (result.startsWith("-") ? 0 - tmp : tmp);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myAtoi("4193 with words"));
    }
}
