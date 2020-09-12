package leetCode.offer.offer55;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
 * 如果某二叉树中任意节点的左右子树的深度相差不超过1，
 * 那么它就是一棵平衡二叉树。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        this.val = x;
    }
}

public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(depth(root.right) - depth(root.left)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    private static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int depth = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (queue.isEmpty() == false) {
            int n = queue.size();
            for (int i = 0; i < n; i++) { // 将前一层的结点出队
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null) queue.add(treeNode.left);
                if (treeNode.right != null) queue.add(treeNode.right);
            }
            depth++;
        }
        return depth;
    }
}
