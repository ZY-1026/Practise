package leetCode.letcode86;

import leetCode.utils.ListNode;

public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode h1 = new ListNode(-1); // 记录小于x的结点组成的链表
        ListNode h2 = new ListNode(-1); // 记录大于x的结点组成的链表
        ListNode p1 = h1, p2 = h2;
        while (head != null) {
            if (head.val < x) {
                p1.next = head;
                p1 = p1.next;
            } else {
                p2.next = head;
                p2 = p2.next;
            }
            head = head.next;
        }
        // 将两个链表拼接
        p2.next = null;
        p1.next = h2.next;
        return h1.next;
    }
}
