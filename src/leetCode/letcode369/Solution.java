package leetCode.letcode369;

import leetCode.utils.ListNode;

public class Solution {
    public ListNode plusOne(ListNode head) {
        if (head == null) return head;
        // 哨兵结点
        ListNode sential = new ListNode(0);
        sential.next = head;
        ListNode notNine = sential;
        while (head != null) {
            if (head.val != 9) notNine = head;
            head = head.next;
        }

        notNine.val++;
        notNine = notNine.next;
        while (notNine != null) {
            notNine.val = 0;
            notNine = notNine.next;
        }
        return sential.val != 0 ? sential : sential.next;
    }
}
