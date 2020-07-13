package huawei.HJ105;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nums = scanner.nextLine().split(" ");
        int count = 0;
        double sum = 0.0;
        for (String num : nums){
            int tmp = Integer.parseInt(num);
            if (tmp < 0) {
                count ++;
            }else{
                sum+=tmp;
            }
        }
        if (count == nums.length){
            sum = 0.0;
        }else{
            sum = Math.round(sum / (nums.length - count) * 10.0) / 10.0 ;
        }
        System.out.println(count);
        System.out.println(sum);
    } // main
}
