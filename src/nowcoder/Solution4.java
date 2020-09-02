package nowcoder;

import leetCode.utils.ListNode;

import java.util.HashSet;

/**
 * 判断链表是否有环
 * <p>
 * https://www.nowcoder.com/practice/650474f313294468a4ded3ce0f7898b9?tpId=188&&tqId=35140&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
 */

public class Solution4 {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        HashSet<ListNode> hashSet = new HashSet<>();
        while (head != null) {
            if (hashSet.contains(head)) return true;
            else {
                hashSet.add(head);
                head = head.next;
            }
        }
        return false;
    }
}
