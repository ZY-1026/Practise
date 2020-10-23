package leetCode.leetcode538;

import leetCode.utils.TreeNode;

public class Solution {
    public int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) return root;
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }
}
