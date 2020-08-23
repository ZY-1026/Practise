package bishi.aiqiyi;

import java.util.Scanner;
import java.util.Stack;

public class Main3 {
    private static boolean isValid(String s) {
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
                if (c == '[' && cur != ']') return false;
                if (c == '{' && cur != '}') return false;
            }
        }
        if (stack.isEmpty() == false) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (isValid(s)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
