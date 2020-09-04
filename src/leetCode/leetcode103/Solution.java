package leetCode.letcode103;

import leetCode.utils.TreeNode;

import java.util.*;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> listTmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                listTmp.add(tmp.val);
                if (tmp.left != null) queue.offer(tmp.left);
                if (tmp.right != null) queue.offer(tmp.right);
            }
            list.add(new ArrayList(listTmp));
            listTmp.clear();
        }
        for (int i = 0; i < list.size(); i++) {
            if ((i + 1) % 2 == 0) {
                Collections.reverse(list.get(i));
            }
        }
        return list;
    }
}
