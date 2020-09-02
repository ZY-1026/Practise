package nowcoder;


import leetCode.utils.ListNode;

/**
 * 假设链表中每一个节点的值都在 0 - 9 之间，那么链表整体就可以代表一个整数。
 * 给定两个这种链表，请生成代表两个整数相加值的结果链表。
 * 例如：链表 1 为 9->3->7，链表 2 为 6->3，最后生成新的结果链表为 1->0->0->0。
 * <p>
 * https://www.nowcoder.com/practice/c56f6c70fb3f4849bc56e33ff2a50b6b?tpId=188&&tqId=35171&rp=1&ru=/ta/job-code-high-week&qru=/ta/job-code-high-week/question-ranking
 */
public class Solution8 {
    /**
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public ListNode addInList(ListNode head1, ListNode head2) {
        // write code here
        ListNode one = reverseLinkList(head1), two = reverseLinkList(head2);
        ListNode tmpResult = new ListNode(-1);
        ListNode curNode = tmpResult;
        int carry = 0;
        while (one != null || two != null) {
            int sum = (one != null ? one.val : 0) + (two != null ? two.val : 0) + carry;
            carry = sum / 10;
            curNode.next = new ListNode(sum % 10);
            curNode = curNode.next;
            if (one != null) one = one.next;
            if (two != null) two = two.next;
        }
        if (carry > 0) {
            curNode.next = new ListNode(carry);
        }
        return reverseLinkList(tmpResult.next);
    }

    // 反转链表
    private ListNode reverseLinkList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
