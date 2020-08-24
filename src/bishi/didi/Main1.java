package didi;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        int a, b, c, t1, t2;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (a = 1; a <= 9; a++) {
            for (b = 0; b <= 9; b++) {
                for (c = 0; c <= 9; c++) {
                    t1 = a * 100 + b * 10 + c;
                    t2 = a * 100 + c * 10 + c;
                    if (t1 + t2 == n) {
                        String tmpT1 = String.valueOf(t1);
                        String tmpT2 = String.valueOf(t2);
                        if ((tmpT1.charAt(0) != tmpT1.charAt(1) && tmpT1.charAt(0) != tmpT1.charAt(2) && tmpT1.charAt(1) != tmpT1.charAt(2))
                                && (tmpT2.charAt(0) != tmpT2.charAt(1) && tmpT2.charAt(1) == tmpT2.charAt(2))) {
                            list.add(t1);
                        }
                    }
                }
            }
        }//for-1
        if (list.size() == 0) {
            System.out.println(0);
            return;
        } else {
            Collections.sort(list);
            System.out.println(list.size());
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i));
                System.out.print(" ");
                System.out.println(n - list.get(i));
            }
        }
    }
}