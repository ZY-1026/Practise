package tree.visittree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}


public class Solution {


    // 非递归中序遍历二叉树
    public static void InOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            System.out.println(node.val);
            cur = cur.right;
        }
    }

    // 非递归后序遍历二叉树
    public static List<Integer> postOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) continue;
            list.add(node.val);
            stack.push(node.left);
            stack.push(node.right);
        }
        Collections.reverse(list);
        return list;
    }

    // 非递归前序遍历二叉树
    public static void preOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) {
                continue;
            }
            System.out.println(node.val);
            stack.push(node.right);
            stack.push(node.left);
        }
    }
}
