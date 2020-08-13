package leetCode.letcode88;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tmp = new int[m + n];
        int index = 0, i = 0, j = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                tmp[index++] = nums1[i++];
            }

            if (nums1[i] >= nums2[j]) {
                tmp[index++] = nums2[j++];
            }
        } // while

        while (i < m) {
            tmp[index++] = nums1[i++];
        }

        while (j < n) {
            tmp[index++] = nums2[j++];
        }

        for (int a = 0; a < tmp.length; a++) {
            nums1[a] = tmp[a];
        }
    }
}
