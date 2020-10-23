package leetCode.leetcode1038;

import leetCode.utils.TreeNode;

public class Solution {
    public int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root == null) return root;
        bstToGst(root.right);
        sum += root.val;
        root.val = sum;
        bstToGst(root.left);
        return root;
    }
}
