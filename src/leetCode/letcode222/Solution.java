package leetCode.letcode222;

import leetCode.utils.TreeNode;

import java.util.Stack;

public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int count = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            count++;
            if (tmp.right != null) stack.push(tmp.right);
            if (tmp.left != null) stack.push(tmp.left);
        }
        return count;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(new Solution().countNodes(root));
    }
}
