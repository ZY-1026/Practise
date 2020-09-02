package nowcoder;

import leetCode.utils.ListNode;

/**
 * 两个链表的第一个公共节点
 * <p>
 * https://www.nowcoder.com/practice/6ab1d9a29e88450685099d45c9e31e46?tpId=188&&tqId=35156&rp=1&ru=/ta/job-code-high-week&qru=/ta/job-code-high-week/question-ranking
 */

public class Solution7 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode one = pHead1, two = pHead2;
        while (one != two) {
            one = ((one == null) ? pHead2 : one.next);
            two = ((two == null) ? pHead1 : two.next);
        }
        return two;
    }
}
