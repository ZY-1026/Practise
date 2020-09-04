package leetCode.letcode513;

import leetCode.utils.TreeNode;

import java.util.*;

public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        if (root.left == null && root.right == null) return root.val;
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> lists = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Integer[] arr = new Integer[size];
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                arr[i] = tmp.val;
                if (tmp.left != null) queue.add(tmp.left);
                if (tmp.right != null) queue.add(tmp.right);
            }
            lists.add(Arrays.asList(arr));
        }
        return lists.get(lists.size() - 1).get(0);
    }
}
