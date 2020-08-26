package leetCode.mytest;

import java.util.Arrays;
import java.util.Stack;


public class Solution4 {
    /**
     * 十进制转二进制：整型范围内
     *
     * @param n : 一个整型数
     * @return：返回该整型数转化为二进制后的字符串形式
     */
    private static String toBinaryNumber(int n) {
        if (n == 0) return String.valueOf(0);
        // 标记n是否为负数
        boolean flag = false;
        if (n < 0) {
            n = 0 - n;
            flag = true;
        }
        Stack<Integer> stack = new Stack<>();
        while (n != 0) {
            stack.push(n % 2);
            n /= 2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (!flag) { // 如果不是负数
            while (!stack.isEmpty()) {
                stringBuilder.append(stack.pop());
            }
            return stringBuilder.toString();
        } else {
            while (!stack.isEmpty()) {
                int tmp = (stack.pop() == 0 ? 1 : 0);
                stringBuilder.append(tmp);
            }
            StringBuilder result;
            result = new StringBuilder(addBinaryNum(stringBuilder.toString(), "1"));
            if (result.length() < 32) { // 补齐32位
                int cut = 32 - result.length();
                char[] c = new char[cut];
                Arrays.fill(c, '1');
                StringBuilder sb = new StringBuilder(String.valueOf(c));
                return sb.toString() + result.toString();
            } else {
                return result.toString();
            }
        }
    }

    /**
     * 二进制相加
     *
     * @param a：一个二进制数的字符串表示
     * @param b：一个二进制数的字符串表示
     * @return：返回两数相加后的字符串表示
     */
    private static String addBinaryNum(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int x;
        int y;
        int pre = 0;//进位
        int sum;//存储进位和另两个位的和

        while (a.length() != b.length()) {//将两个二进制的数位数补齐,在短的前面添0
            if (a.length() > b.length()) {
                b = "0" + b;
            } else {
                a = "0" + a;
            }
        }
        for (int i = a.length() - 1; i >= 0; i--) {
            x = a.charAt(i) - '0';
            y = b.charAt(i) - '0';
            sum = x + y + pre;//从低位做加法
            if (sum >= 2) {
                pre = 1;//进位
                sb.append(sum - 2);
            } else {
                pre = 0;
                sb.append(sum);
            }
        }
        if (pre == 1) {
            sb.append("1");
        }
        return sb.reverse().toString();//翻转返回
    }

    public static void main(String[] args) {
        // 自己的实现
        System.out.println(toBinaryNumber(-989524255));
        // java底层库的实现
        System.out.println(Integer.toBinaryString(-989524255));
    }
}
