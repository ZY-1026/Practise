package leetCode.letcode25;

import leetCode.utils.ListNode;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int length = 0;
        ListNode cur = head;
        // 计算链表长度
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        int index = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        while(end.next!=null){
            for (int i=0;i<k&&end!=null;i++) end = end.next;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;

        }
        return null;
    }
}
