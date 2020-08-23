package bishi.meituan;

import java.util.*;

public class Test2 {
    public static int helper(String[] strings) {
        int count = 0;
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < strings.length; i++) {
            if (!hashSet.contains(strings[i])) hashSet.add(strings[i]);
            else hashSet.remove(strings[i]);
            if (hashSet.isEmpty() == true) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] ori = new String[2 * n];
        int index = 0;
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String[] strings = sc.nextLine().split(" ");
            for (int j = 0; j < strings.length; j++) {
                ori[index++] = strings[j];
            }
        }
        System.out.println(helper(ori));
    }
}
