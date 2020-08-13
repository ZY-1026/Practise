package leetCode.letcode889;

import leetCode.utils.TreeNode;

import java.util.Arrays;

public class Solution {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (post == null && pre == null) return null;
        if (post.length == 0 && pre.length == 0) return null;
        if (pre.length == 0) return null;
        TreeNode root = new TreeNode(pre[0]);
        if (pre.length == 1) return root;
        int L = 0;
        for (int i = 0; i < pre.length; i++) {
            if (post[i] == pre[1])
                L = i + 1;
        }
        root.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, L + 1),
                Arrays.copyOfRange(post, 0, L));
        root.right = constructFromPrePost(Arrays.copyOfRange(pre, L + 1, pre.length),
                Arrays.copyOfRange(post, L, pre.length - 1));
        return root;
    }
}
