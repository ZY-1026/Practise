package leetCode.offer.offer33;

public class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return helper(postorder, 0, postorder.length - 1);
    }

    private boolean helper(int[] post, int i, int j) {
        if (i > j) return true;
        int p = i;
        // 左子树区间
        while (post[p] < post[j]) p++;
        int m = p;
        // 右子树区间
        while (post[p] > post[j]) p++;
        return p == j && helper(post, i, m - 1) && helper(post, m, j - 1);
    }
}
