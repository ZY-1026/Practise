package leetCode.letcode199;

import leetCode.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 按照根节点，右子树，左子树的顺序访问 能够保证每次最先看到最右边的结点
public class Solution {
//    public List<Integer> list = new ArrayList<>();
//
//    public List<Integer> rightSideView(TreeNode root) {
//        dfs(root, 0);
//        return list;
//    }
//
//    private void dfs(TreeNode root, int depth) {
//        if (root == null) return;
//        if (depth == list.size()) list.add(root.val);
//        depth++;
//        dfs(root.right, depth);
//        dfs(root.left, depth);
//    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                if (i == 0) result.add(tmp.val);
                // 从右向左记录下一层
                if (tmp.right != null) queue.add(tmp.right);
                if (tmp.left != null) queue.add(tmp.left);
            }
        }
        return result;
    }
}
