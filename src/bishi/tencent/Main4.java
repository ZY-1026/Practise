package bishi.tencent;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int max = 0;
        sc.nextLine();
        String[] strings = sc.nextLine().split(" ");
        for (int i=0;i<n;i++){
            nums[i] = Integer.valueOf(strings[i]);
        }
        for (int i:nums)
            max = i>max?i:max;
        int res = 1;
        if (nums[0] !=max) res++;
        for (int i=1;i<nums.length;i++){
            if (nums[i]!=nums[i-1]&&nums[i]!=max){
                res++;
            }
        }
        System.out.println(res);
    }
}
