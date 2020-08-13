package huawei.bishi.test1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        int[] a = new int[2];
        for (int i = 0; i < strings.length; i++) {
            int tmp = Integer.valueOf(strings[i]);
            a[i] = help(tmp);
        }
        if (a[1] == 0) return;
        System.out.println(a[0] % a[1]);
    }

    private static int help(int x) {
        List<Integer> list = new ArrayList<>();
        while (x != 0) {
            list.add(x % 10);
            x = x / 10;
        }
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            result += list.get(i);
        }
        return result;
    } // help
}
