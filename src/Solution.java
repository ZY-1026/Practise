import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {4, 4, 5, 5, 6, 7, 0, 1, 6, 7};
        int[] res = helper(nums);
        //System.out.println(res.length);
        Arrays.sort(res);
        for (int num : res) {
            System.out.println(num);
        }
    }

    private static int[] helper(int[] nums) {
        int[] res = new int[2];
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        int tmp = 1;
        while ((result & tmp) == 0) {
            // System.out.println(tmp);
            tmp = tmp << 1;
        }
        int result1 = 0;
        int result2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & tmp) == 1) {
                result1 ^= nums[i];
            } else {
                result2 ^= nums[i];
            }
        }
        res[0] = result1;
        res[1] = result2;
        return res;
    }
}
