package leetCode.letcode34;

public class Solution1 {
    public int[] searchRange(int[] nums, int target) {
        int right = higher_bound(nums, target);
        int left = lower_bound(nums, target);
        return new int[]{left, right};
    }

    private int higher_bound(int[] a, int v) {
        int l = 0;
        int r = a.length - 1;
        int res = -1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (a[mid] < v) {
                l = mid + 1;
            } else if (a[mid] > v) {
                r = mid - 1;
            } else {
                res = mid;
                l = mid + 1;
            }
        }
        return res;
    }

    private int lower_bound(int[] a, int v) {
        int l = 0;
        int r = a.length - 1;
        int res = -1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (a[mid] > v) {
                r = mid - 1;
            } else if (a[mid] < v) {
                l = mid + 1;
            } else {
                res = mid;
                r = mid - 1;
            }
        }
        return res;
    }
}
