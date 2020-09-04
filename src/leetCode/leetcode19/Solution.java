package leetCode.leetcode19;

import leetCode.utils.ListNode;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = 0;
        ListNode first = head;
        // 总共有多少个元素
        while (first != null) {
            length++;
            first = first.next;
        }

        // 删除第length-n个元素
        length -= n;

        // first重新指向dummy
        first = dummy;

        // 将first指向第length-n个元素
        while (length > 0) {
            length--;
            first = first.next;
        }
        // 重置指针
        first.next = first.next.next;
        return dummy.next;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode one = dummy, two = dummy;
        for (int i = 0; i <= n; i++) {
            one = one.next; // 快指针
        }
        while (one != null) {
            one = one.next;
            two = two.next;
        }
        two.next = two.next.next;
        return dummy.next;
    }
}
