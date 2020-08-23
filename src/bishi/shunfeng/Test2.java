package bishi.shunfeng;

import java.util.Scanner;

public class Test2 {
    public static int greedySelector(long[] s, long[] f, boolean[] a) {
        int n = s.length - 1;
        a[1] = true;//第一个活动被选中
        int j = 1;
        int count = 1;//被选中活动的数量，默认第一个活动被选中
        for (int i = 2; i <= n; i++) {
            if (s[i] >= f[j]) {//下一个活动开始时间大于大于等于上一个活动结束时间
                a[i] = true;
                j = i;
                count++;
            } else {
                a[i] = false;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] s = new long[n + 1];
        long[] f = new long[n + 1];
        long[] value = new long[n + 1];
        boolean[] a = new boolean[n + 1];
        s[0] = -1;
        f[0] = -1;
        value[0] = -1;
        String[] strings = new String[n];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            strings[i] = sc.nextLine();
        }
        for (int i = 0; i < n; i++) {
            String[] tmp = strings[i].split(" ");
            s[i + 1] = Long.valueOf(tmp[0]);
            f[i + 1] = Long.valueOf(tmp[1]);
            value[i + 1] = Long.valueOf(tmp[2]);
        } // for
        greedySelector(s, f, a);
        long result = 0;
        for (int i = 1; i <= s.length - 1; i++) {
            if (a[i]) {
                result += value[i];
            }
        }
        System.out.print(result);
    }
}
