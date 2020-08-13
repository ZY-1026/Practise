package leetCode.letcode124;

import leetCode.utils.TreeNode;

public class Solution {
    public int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    /** 计算结点root的最大贡献值，就是在以该节点为根节点的子树中寻找以该节点为
            起点的一条路径，使得该路径上的节点值之和最大。
     **/
    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);
        // 结点的最大；路径和取决于该节点的值与该节点的左右子节点的最大值
        int tmp = root.val + left + right;
        maxSum = Math.max(tmp, maxSum);
        return root.val + Math.max(left, right);
    }
}
