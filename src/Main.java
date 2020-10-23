public class Main {
    public static int[] helper(int[] nums, int cycle) {
        int[] res = new int[nums.length];
        if (nums == null) return res;
        // 进行cycle次循环
        for (int i = 0; i < cycle; i++) {
            // 进行一次周期变化
            res = fun(nums);
            // 每次变化之后将nums赋值为上次的结果
            nums = res;
        }
        return res;
    }

    // 进行一次时钟周期
    private static int[] fun(int[] nums) {
        int[] res = new int[nums.length];
        if (nums == null || nums.length == 0) return res;
        res[0] = nums[0];
        res[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i <= nums.length - 2; i++) {
            if (i + 1 <= nums.length - 1) {
                if (nums[i - 1] == nums[i + 1]) {
                    res[i] = 1;
                } else {
                    res[i] = 0;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 1, 1, 0, 0, 1};
        int cycle = 1;
        int[] res = helper(nums, cycle);
        for (int num : res) {
            System.out.print(num + "    ");
        }
    }
}
