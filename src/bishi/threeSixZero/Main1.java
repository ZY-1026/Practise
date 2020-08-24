package bishi.threeSixZero;

import java.util.Scanner;

public class Main1 {
    private static boolean helper(String s) {
        String tmp = s;
        StringBuilder stringBuilder = new StringBuilder(tmp);
        return stringBuilder.reverse().toString().equals(s);
    }

    private static boolean isBalanceChar(char c) {
        boolean one = (c == 'A');
        boolean two = (c == 'H');
        boolean threee = (c == 'I');
        boolean four = (c == 'M');
        boolean five = (c == 'O');
        boolean six = (c == 'T');
        boolean seven = (c == 'U');
        boolean eight = (c == 'V');
        boolean nigh = (c == 'W');
        boolean ten = (c == 'Y');
        return !one && !two && !threee && !four && !five && !six
                && !seven && !eight && !nigh && !ten;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            for (int i = 0; i < s.length(); i++) {
                if (isBalanceChar(s.charAt(i))) {
                    System.out.print("NO");
                    return;
                }
            }
            boolean one = helper(s);
            if (one == false) {
                System.out.print("NO");
                return;
            } else {
                System.out.print("YES");
                return;
            }
        }
    }
}
