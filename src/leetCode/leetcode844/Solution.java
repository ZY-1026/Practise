package leetCode.leetcode844;


import java.util.Stack;

public class Solution {
    public boolean backspaceCompare(String S, String T) {
        if ((S == null && T == null) || (S.length() == 0 && T.length() == 0)) return true;
        return build(S).equals(build(T));
    }

    public String build(String string) {
        StringBuilder res = new StringBuilder();
        int length = string.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            if (string.charAt(i) != '#') {
                stack.push(string.charAt(i));
            } else {
                if (stack.isEmpty() == false) {
                    stack.pop();
                }
            }
        }//for
        while (stack.isEmpty() == false) {
            res.append(stack.pop());
        }
        return res.toString();
    }
}
