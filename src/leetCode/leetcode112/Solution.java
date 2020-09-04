package leetCode.letcode112;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，
 * 这条路径上所有节点值相加等于目标和。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
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
    public List<List<Integer>> res = new ArrayList<>();
    public List<Integer> path = new ArrayList<>();

    public boolean hasPathSum(TreeNode root, int sum) {
        helper(root);
        for (int i = 0; i < res.size(); i++) {
            if (sum(res.get(i)) == sum) return true;
        }
        return false;
    }

    // 计算二叉树中的所有从根节点到叶子结点的路径
    public void helper(TreeNode root) {
        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null) res.add(new ArrayList<>(path));
        helper(root.left);
        helper(root.right);
        path.remove(path.size() - 1);
    }

    public int sum(List<Integer> list) {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            count += list.get(i);
        }
        return count;
    }
}
