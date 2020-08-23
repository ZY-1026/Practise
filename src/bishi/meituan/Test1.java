package bishi.meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test1 {
    public static boolean helper(long nums) {
        String tmp = String.valueOf(nums);
        StringBuilder stringBuilder = new StringBuilder(tmp);
        String reverse = stringBuilder.reverse().toString();
        long result = Long.valueOf(reverse).longValue();
        return result == nums * 4;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        List<Long> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            long iValue = Long.valueOf(i).longValue();
            if (iValue * 4 > n) break;
            if (helper(iValue)) list.add(iValue);
            else continue;
        }
        int size = list.size();
        if (size != 0) {
            System.out.println(size);
            for (int i = 0; i < size; i++) {
                long num = list.get(i).longValue();
                System.out.print(num);
                System.out.println(" " + num * 4);
            }
        } else {
            System.out.println(0);
        }
    }
}
