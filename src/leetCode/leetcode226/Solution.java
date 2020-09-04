package leetCode.letcode226;

import leetCode.utils.TreeNode;

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        return helper(root);
    }

    public TreeNode helper(TreeNode root) {
        if (root == null) return root;
        helper(root.left);
        helper(root.right);
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        return root;
    }
}
