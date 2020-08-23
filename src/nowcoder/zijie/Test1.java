package nowcoder.zijie;

/***
 * 题目描述
 * 数列的定义如下：数列的第一项为n，以后各项为前一项的平方根，求数列的前m项的和。
 *
 * 输入描述:
 * 输入数据有多组，每组占一行，由两个整数n（n<10000）和m(m<1000)组成，n和m的含义如前所述。
 * 输出描述:
 * 对于每组输入数据，输出该数列的和，每个测试实例占一行，要求精度保留2位小数。
 * 示例1
 * 输入
 * 81 4
 * 2 2
 * 输出
 * 94.73
 * 3.41
 *
 * https://www.nowcoder.com/practice/fe19f8a78a5148018f4be53ae9b5e11e?tpId=137&rp=1&ru=%2Fta%2Fexam-bytedance&qru=%2Fta%2Fexam-bytedance%2Fquestion-ranking
 */

import java.io.*;
public class Test1{
    public static double sumOfArray(int n, int m){
        double ans = n;
        double t = n;
        for(int i = 1;i<m;i++){
            t = Math.sqrt(t);
            ans+=t;
        }
        return ans;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        while((s=bf.readLine())!=null){
            String[] arr = s.split(" ");
            int n = Integer.valueOf(arr[0]);
            int m = Integer.valueOf(arr[1]);
            double result = sumOfArray(n, m);
            System.out.printf("%.2f\n", result);
        }
    }
}
