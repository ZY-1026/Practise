package leetCode.letcode145;

import leetCode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (stack1.isEmpty() == false) {
            root = stack1.pop();
            stack2.push(root);
            if (root.left != null) {
                stack1.push(root.left);
            }
            if (root.right != null) {
                stack2.push(root.right);
            }
        }
        while (!stack2.isEmpty()) {
            list.add(stack2.peek().val);
            stack2.pop();
        }
        return list;
    }
}
