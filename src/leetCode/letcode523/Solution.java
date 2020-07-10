package leetCode.letcode523;

/**
 给定一个包含 非负数 的数组和一个目标 整数 k，编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，且总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/continuous-subarray-sum
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


 * 动态规划
 */

public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
       for(int start = 0; start < nums.length-1 ; start++) {
           for (int end = start + 1; end < nums.length; end++) {
               int sum = 0;
               for (int i = start; i <= end; i++) {
                   sum = sum + nums[i];
               } // for -3

               if(sum==k || (k!=0 && sum%k==0)){
                   return true;
               }
           } // for-2
       } //for-1
        return false;
    } // function
}
