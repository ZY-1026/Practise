package bishi.kedaxunfei;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        int[] a = {1, 5, 10, 50, 100};//面值
        int[] b = new int[5];//输入的个数
        int pay; //客户支付金额
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < b.length; i++) {
            b[i] = scanner.nextInt();
        }
        pay = scanner.nextInt();
        for (int i = b.length - 1; i >= 0; i--) {
            int n = Math.min(pay / a[i], b[i]); //n = (当前硬币数  ， 实际硬币数 ) 取最小值
            pay = pay - a[i] * n; //当前剩余金额
            count += n;
        }
        if (pay == 0) {
            System.out.println(count);
        } else {
            System.out.println(-1);
        }
    }
}