package leetCode.leetcode23;

import leetCode.utils.ListNode;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 1) return lists[0];
        if (lists.length == 0 || lists == null) return null;
        ListNode ans = null;
        for (int i = 0; i < lists.length; i++) {
            ans = merge(ans, lists[i]);
        }
        return ans;
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode dummy = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                dummy.next = l1;
                l1 = l1.next;
            } else {
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }

        if (l1 != null) {
            dummy.next = l1;
        }
        if (l2 != null) {
            dummy.next = l2;
        }
        return head.next;
    }
}
