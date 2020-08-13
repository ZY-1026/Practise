package kedaxunfei;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            s = helper(s);
            System.out.println(new StringBuilder(s).toString());
        }
    }

    public static String helper(String s) {
        if (s == null && s.length() == 0) return s;
        int length = s.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (Character.isDigit(s.charAt(i))) {
                stringBuilder.append(s.charAt(i));
            }
        }
        boolean flag = s.startsWith("-");
        return flag == true ? stringBuilder.insert(0, '-').toString() : stringBuilder.toString();
    }
}
