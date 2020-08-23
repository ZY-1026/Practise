package leetCode.letcode739;

public class Solution {
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) return null;
        int length = T.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            int current = T[i];
            if (current < 100) {
                for (int j = i + 1; j < length; j++) {
                    if (T[j] > current) {
                        result[i] = j - i;
                        break;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] T = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        for (int num : new Solution().dailyTemperatures(T)) {
            System.out.println(num);
        }
    }
}
