package nowcoder;

import leetCode.utils.ListNode;

/**
 * 给定一个链表，删除链表的倒数第n个节点并返回链表的头指针
 * <p>
 * https://www.nowcoder.com/practice/f95dcdafbde44b22a6d741baf71653f6?tpId=188&&tqId=35153&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
 */

public class Solution6 {
    /**
     * @param head ListNode类
     * @param n    int整型
     * @return ListNode类
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // write code here
        if (head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
