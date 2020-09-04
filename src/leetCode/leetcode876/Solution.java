package leetCode.letcode876;

import leetCode.utils.ListNode;

public class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) return head;
        int length = 0;
        ListNode tmp = head;
        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }
        int mid = length >> 1;
        int curIndex = 1;
        ListNode cur = head;
        while (curIndex < mid) {
            cur = cur.next;
            curIndex++;
        }
        return cur.next;
    }
}
