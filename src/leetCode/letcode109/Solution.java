package leetCode.letcode109;

import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    private List<Integer> values;

    public Solution() {
        values = new ArrayList<>();
    }

    public TreeNode sortedListToBST(ListNode head) {
        this.toArraylist(head);
        return createTree(0, this.values.size() - 1);
    }

    private void toArraylist(ListNode head) {
        while (head != null) {
            this.values.add(head.val);
            head = head.next;
        }
    }

    private TreeNode createTree(int low, int high) {
        if (low > high) return null;
        int mid = (low + high) / 2;
        TreeNode root = new TreeNode(this.values.get(mid));
        if (high == low) return root;
        root.left = createTree(low, mid - 1);
        root.right = createTree(mid + 1, high);
        return root;
    }
}
