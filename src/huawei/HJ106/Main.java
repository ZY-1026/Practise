package huawei.HJ106;

import java.util.Scanner;

public class Main {
    public static String Solution(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = s.length() - 1; j >= 0; j--) {
            stringBuilder.append(s.charAt(j));
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(Solution(new Scanner(System.in).nextLine()));
    }
}
