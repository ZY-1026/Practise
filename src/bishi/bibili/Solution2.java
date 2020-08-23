package bishi.bibili;

import java.util.Stack;

public class Solution2 {
    /**
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean IsValidExp(String s) {
        // write code here
        if (s.length() == 1) return false;
        if (s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) return false;
                char c = stack.pop();
                char cur = s.charAt(i);
                if (c == '(' && cur != ')') return false;
                if (c == '{' && cur != '}') return false;
                if (c == '[' && cur != ']') return false;
            }
        }
        if (!stack.isEmpty()) return false;
        return true;
    }
}
