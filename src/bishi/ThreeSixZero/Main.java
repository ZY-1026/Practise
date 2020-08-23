package ThreeSixZero;

import java.util.Scanner;

public class Main {
    private static boolean isValid(String name) {
        if (name.length() > 10) return false;
        for (int i = 0; i < name.length(); i++) {
            if (helper(name.charAt(i)) == false) return false;
        }
        return true;
    }

    private static boolean helper(char c) {
        boolean one = (c >= 'A' && c <= 'Z');
        boolean two = (c >= 'a' && c <= 'z');
        return one || two;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        String[] strings = new String[n];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            strings[i] = sc.nextLine();
        }
        for (int i = 0; i < n; i++) {
            if (isValid(strings[i])) count++;
        }
        System.out.println(count);
        sc.close();
    }
}
