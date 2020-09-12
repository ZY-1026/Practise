package leetCode.offer.offer22;

import leetCode.utils.ListNode;

public class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) return null;
        ListNode former = head, latter = head;
        for (int i = 0; i < k; i++)
            former = former.next;
        while (former != null) {
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }
}
