package leetCode.letcode111;

import leetCode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        String cur = "";
        List<String> result = new ArrayList<>();
        cal(root, cur, result);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < result.size(); i++) {
            String[] s = result.get(i).split(" ");
            if (s.length < ans) ans = s.length;
        }
        return ans;
    }

    private void cal(TreeNode node, String cur, List<String> result) {
        if (node != null) {
            cur += node.val;
            if (node.right == null && node.left == null) {
                result.add(cur);
            } else {
                cur += " ";
                cal(node.left, cur, result);
                cal(node.right, cur, result);
            }
        }// if
    }
}
