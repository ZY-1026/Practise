package leetCode.interview0404;

import leetCode.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：
 * 任意一个节点，其两棵子树的高度差不超过 1。
 * <p>
 * <p>
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-balance-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution {
    public boolean isBalanced(TreeNode root) {
//        if (root == null) return true;
//        if (root.left == null && root.right == null) return true;
//        if (Math.abs(depth(root.right) - depth(root.left)) > 1) return false;
//        return isBalanced(root.left) && isBalanced(root.right);
        return dfs(root) != -1;
    }

    private static int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        if (left == -1) return -1;
        int right = dfs(root.right);
        if (right == -1 || Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }

    private static int depth(TreeNode root) {
        if (null == root) return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        int height = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = ((ArrayDeque<TreeNode>) queue).removeFirst();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            height++;
        }
        return height;
    }
}
