package leetCode.letcode34;

public class Solution2 {
    public int[] searchRange(int[] nums, int target) {
        int size = nums.length;
        int left = lower_bound(nums, 0, size - 1, target);
        int right = higher_bound(nums, 0, size - 1, target);
        return new int[]{left, right};
    }

    private int higher_bound(int[] nums, int low, int high, int target) {
        if (low > high) return -1;
        int mid = (low + high) >> 1;
        if (nums[mid] == target) {
            int index = higher_bound(nums, mid + 1, high, target);
            return index == -1 ? mid : index;
        } else if (nums[mid] > target) {
            return higher_bound(nums, low, mid - 1, target);
        } else {
            return higher_bound(nums, mid + 1, high, target);
        }

    }

    private int lower_bound(int[] nums, int low, int high, int target) {
        if (low > high) return -1;
        int mid = (low + high) >> 1;
        if (nums[mid] == target) {
            int index = lower_bound(nums, low, mid - 1, target);
            return index == -1 ? mid : index;
        } else if (nums[mid] > target) {
            return lower_bound(nums, low, mid - 1, target);
        } else {
            return lower_bound(nums, mid + 1, high, target);
        }
    }

    public static void main(String[] args) {
        Integer i01 = -128;
        int i02 = -128;
        Integer i03 = Integer.valueOf(-128);
        Integer i04 = new Integer(-128);
        System.out.println(i03==i04);
    }
}
