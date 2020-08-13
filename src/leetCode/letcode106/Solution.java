package leetCode.letcode106;

import leetCode.utils.TreeNode;

import java.util.Arrays;

public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) {
            return null;
        }
        return helper(inorder, postorder);
    }

    private TreeNode helper(int[] in, int[] post) {
        if (in.length == 0) return null;
        // 根据后续最后一个元素创建根节点
        TreeNode root = new TreeNode(post[post.length - 1]);
        // 在中序中查找根节点的位置
        for (int i = 0; i < in.length; i++) {
            if (in[i] == post[post.length - 1]) {
                int[] inLeft = Arrays.copyOfRange(in, 0, i);
                int[] inRight = Arrays.copyOfRange(in, i + 1, in.length);
                int[] postLeft = Arrays.copyOfRange(post, 0, i);
                int[] postRight = Arrays.copyOfRange(post, i, post.length - 1);
                root.left = helper(inLeft, postLeft);
                root.right = helper(inRight, postRight);
            }
        }
        return root;
    }
}
