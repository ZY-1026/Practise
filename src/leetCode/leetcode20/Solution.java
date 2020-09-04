package leetCode.leetcode20;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        if (s.length() == 0 || s.length() == 1) return false;
        Stack<Character> stack = new Stack<>();
        if (s.charAt(0) == ')' || s.charAt(0) == ']' || s.charAt(0) == '}') return false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else { // 如果不是左括号
                if (stack.isEmpty()) return false;
                char c = stack.pop();
                char cur = s.charAt(i);
                if (c == '(' && cur != ')') return false;
                if (c == '{' && cur != '}') return false;
                if (c == '[' && cur != ']') return false;
            }
        }
        if (stack.isEmpty() == false) return false;
        return true;
    }
}
