package leetCode.letcode101;

import leetCode.utils.TreeNode;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }

    public boolean helper(TreeNode treeNode1, TreeNode treeNode2) {
        if (treeNode1 == null && treeNode2 == null) return true;
        if (treeNode1 == null || treeNode2 == null) return false;
        boolean val = (treeNode1.val == treeNode2.val);
        // 判断右子树和左子树是否对称
        boolean lr = helper(treeNode1.left, treeNode2.right);
        // 判断左子树和右子树是否对称
        boolean rl = helper(treeNode1.right, treeNode2.left);
        return val && lr && rl;
    }
}
