package leetCode.leetcode344;


public class Solution {
    public void reverseString(char[] s) {
        if (s == null || s.length == 0) return;
        int low = 0, high = s.length - 1;
        while (low < high) {
            char tmp = s[low];
            s[low] = s[high];
            s[high] = tmp;
            low++;
            high--;
        }
    }
}
