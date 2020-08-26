import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = sc.nextInt();
        sc.nextLine();
        char[] c = s.toCharArray();
        int[] tmp = new int[c.length];
        int in = 0;
        for (char c1 : c) {
            tmp[in++] = Integer.valueOf(c1) - '0';
        }
        for (int i = 0; i < n; i++) {
            int n1 = sc.nextInt(), n2 = sc.nextInt();
            int index = s.indexOf(String.valueOf(n1));
            if (index == -1) {
                continue;
            } else {
                for (int j = 0; j < c.length; j++) {
                    if (tmp[j] == n1) {
                        tmp[j] = n2;
                    }
                }
            } // else
        } // for-1
        StringBuilder stringBuilder = new StringBuilder();
        for (int m = 0; m < tmp.length; m++) {
            stringBuilder.append(tmp[m]);
        }
        System.out.println(stringBuilder.toString());
        sc.close();
    }
}
