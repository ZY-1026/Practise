package leetCode.letcode102;

import leetCode.utils.TreeNode;

import java.util.*;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Integer[] arr = new Integer[size];
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                arr[i] = treeNode.val;
                if (treeNode.left != null) queue.offer(treeNode.left);
                if (treeNode.right != null) queue.offer(treeNode.right);
            }
            lists.add(Arrays.asList(arr));
        } // while
        return lists;
    }
}
