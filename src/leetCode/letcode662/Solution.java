package leetCode.letcode662;

/**
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 * <p>
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * <p>
 * 1
 * /   \
 * 3     2
 * / \     \
 * 5   3     9
 * <p>
 * 输出: 4
 * 解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-width-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import leetCode.utils.TreeNode;

import java.util.*;

public class Solution {
    private int max;

    public int widthOfBinaryTree(TreeNode root) {
        max = 0;
        List<Integer> left = new ArrayList<>();
        dfs(root, 0, 0, left);
        return max;
    }

    private void dfs(TreeNode root, int depth, int pos, List<Integer> left) {
        if (root == null) return;
        if (left.size() <= depth) {
            left.add(pos);
        }
        int width = pos - left.get(depth) + 1;
        max = Math.max(max, width);
        dfs(root.left, depth + 1, 2 * pos, left);
        dfs(root.right, depth + 1, 2 * pos + 1, left);
    }

    public int widthOfBinaryTree2(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        int maxWidth = 1;
        queue.add(root);
        while (true) {
            int len = queue.size();
            if (len == 0) break;
            while (len > 0) {
                TreeNode t = queue.poll();
                len--;
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            } // while
            maxWidth = Math.max(maxWidth, queue.size());
        }
        return maxWidth;
    }
}
