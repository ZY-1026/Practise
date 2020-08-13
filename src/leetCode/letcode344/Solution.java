package leetCode.letcode344;

public class Solution {
    public void reverseString(char[] s) {
        if (s == null || s.length == 0) return;
        int low = 0, high = s.length - 1;
        while (low < high) {
            swap(s, low, high);
            low++;
            high--;
        }
    }

    private void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}
