package offer.test07;

import leetCode.utils.TreeNode;

import java.util.Arrays;

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        // 找根节点在中序中的位置
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (preorder[0] == inorder[i])
                index = i;
        }

        int[] preLeft = Arrays.copyOfRange(preorder, 1, index + 1);
        int[] preRight = Arrays.copyOfRange(preorder, index + 1, preorder.length);
        int[] inLeft = Arrays.copyOfRange(inorder, 0, index);
        int[] inRight = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);
        return root;
    }
}
