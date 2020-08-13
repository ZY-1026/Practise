package offer.test34;

import leetCode.utils.TreeNode;

import java.util.LinkedList;
import java.util.List;


public class Solution {
    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        helper(root, sum);
        return res;
    }

    public void helper(TreeNode root, int tar) {
        if (root == null) return;
        path.add(root.val);
        tar = tar - root.val;
        // 递归终止条件
        if (tar == 0 && root.left == null && root.right == null)
            res.add(new LinkedList<>(path));
        helper(root.left, tar);
        helper(root.right, tar);
        path.removeLast();
    }
}
