package nowcoder;

import leetCode.utils.ListNode;

/**
 * 合并两个有序链表
 * <p>
 * url:https://www.nowcoder.com/practice/a479a3f0c4554867b35356e0d57cf03d?tpId=188&&tqId=35148&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
 */

public class Solution1 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = (l1 != null ? l1 : l2);
        return dummy.next;
    }
}
