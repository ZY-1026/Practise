package leetCode.letcode147;

import leetCode.utils.ListNode;

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode pre = head;
        ListNode cur = head.next;
        dummy.next = head;
        while(cur!=null){
            if (pre.val <= cur.val){
                // 本来就有序
                pre = cur;
                cur = cur.next;
            }else{ // 本来无序
                ListNode p = dummy;
                // 找到第一个位置使得p < cur < p.next
                while(p.next!=cur && p.next.val < cur.val){
                    p = p.next;
                }
                pre.next = cur.next;
                cur.next = p.next;
                p.next = cur;
                cur = pre.next;
            }
        }
        return dummy.next;
    }
}
