package nowcoder;

import leetCode.utils.ListNode;

/**
 * 反转链表
 * <p>
 * url:https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=188&&tqId=35160&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
 */

public class Solution2 {
    public ListNode ReverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
