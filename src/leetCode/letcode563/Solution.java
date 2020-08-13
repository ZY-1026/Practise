package leetCode.letcode563;

import leetCode.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 给定一个二叉树，计算整个树的坡度。
 * 一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。
 * 整个树的坡度就是其所有节点的坡度之和。
 * <p>
 * 示例：
 * 输入：
 * 1
 * /   \
 * 2     3
 * 输出：1
 * 解释：
 * 结点 2 的坡度: 0
 * 结点 3 的坡度: 0
 * 结点 1 的坡度: |2-3| = 1
 * 树的坡度 : 0 + 0 + 1 = 1
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-tilt
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution {
    public int tilt = 0;

    public int findTilt(TreeNode root) {
        if (root == null) return 0;
        if (root.right == null && root.left == null) return 0;
        // 理解错了 以为是每层结点之差
//        Queue<TreeNode> queue = new ArrayDeque<>();
//        queue.add(root);
//        int tilt = 0;
//        while (queue.isEmpty() == false) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                int left = 0;
//                int right = 0;
//                TreeNode treeNode = queue.poll();
//                if (treeNode.left != null) {
//                    left = treeNode.left.val;
//                    queue.add(treeNode.left);
//                }
//                if (treeNode.right != null) {
//                    right = treeNode.right.val;
//                    queue.add(treeNode.right);
//                }
//                tilt += Math.abs(left - right);
//            }
//        }
//        return tilt;
        // 递归即可
        helper(root);
        return tilt;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        tilt += Math.abs(left - right);
        return left + right + root.val;
    }
}
