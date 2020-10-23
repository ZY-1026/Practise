package bishi.xinlang;

import leetCode.utils.TreeNode;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        String[] string = sc.nextLine().split(",");
        for (int i = 0; i < string.length; i++) {
            list.add(Integer.valueOf(string[i]));
        }
        sc.close();
        TreeNode treeNode = upsideDownBinaryTree(createTree(list));
        levelTraversal(treeNode);
    }

    // 利用层次遍历方式创建二叉树
    private static TreeNode createTree(List<Integer> list) {
        int size = list.size();
        if (size == 0 || list == null) return null;
        TreeNode root = new TreeNode(list.get(0), null, null);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int cur = 1;
        while (cur < list.size()) {
            TreeNode front = queue.poll();
            front.left = new TreeNode(list.get(cur++), null, null);
            queue.offer(front.left);
            if (cur == size) break;
            front.right = new TreeNode(list.get(cur++), null, null);
            queue.offer(front.right);
        }
        return root;
    }

    private static TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) return root;
        TreeNode l = root.left, r = root.right;
        TreeNode res = upsideDownBinaryTree(l);
        l.left = r;
        l.right = root;
        root.left = null;
        root.right = null;
        return res;
    }

    // 非递归层次遍历
    private static void levelTraversal(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            list.add(treeNode.val);
            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
        }
        // 输出结果
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) System.out.println(list.get(i));
            else System.out.print(list.get(i) + ",");
        }
    }
}
