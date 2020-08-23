package leetCode.letcode150;

import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int a = 0, b = 0;
        for (String val : tokens) {
            if ("+-*/".contains(val)) {
                a = stack.pop();
                b = stack.pop();
            }
            switch (val) {
                case "+":
                    stack.push(a + b);
                    break;
                case "-":
                    stack.push(b - a);
                    break;
                case "/":
                    stack.push(b / a);
                    break;
                case "*":
                    stack.push(a * b);
                    break;
                default:
                    stack.push(new Integer(val));
            }
        }
        return stack.pop();
    }

    public static int evalRPN1(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int a, b;
        for (String num : tokens) {
            if (num.equals("+") || num.equals("-") || num.equals("*") || num.equals("/")) {
                a = stack.pop();
                b = stack.pop();
                if (num.equals("+")) stack.push(b + a);
                if (num.equals("-")) stack.push(b - a);
                if (num.equals("*")) stack.push(b * a);
                if (num.equals("/")) stack.push(b / a);
            } else {
                stack.push(Integer.valueOf(num));
            }
        } // for
        return stack.peek();
    }

    public static void main(String[] args) {
        String[] s = {"0", "3", "/"};
        System.out.println(evalRPN1(s));
    }
}
