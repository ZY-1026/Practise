package leetCode.letcode82;

import java.util.ArrayList;
import java.util.List;

import leetCode.utils.ListNode;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * <p>
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode root = head;
        List<Integer> list = new ArrayList<>();
        while (root != null) {
            if (root.val == root.next.val) {
                System.out.println(root.val);
                if (list.contains(root.val) == false) {
                    list.add(root.val);
                }
            }
            root = root.next;
        }

        root = head;
        ListNode result = new ListNode(-1);
        while (root != null) {
            if (!list.contains(root.val)) {
                result.next = new ListNode(root.val);
            }
            root = root.next;
        }

        return result.next;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = head;
        while (second != null && second.next != null) {
            if (first.next.val != second.next.val) {
                first = first.next;
                second = second.next;
            } else {
                while (second != null && second.next != null && first.next.val == second.next.val) {
                    second = second.next;
                }
                first.next = second.next;
                second = second.next;
            }
        }
        return dummy.next;
    }
}
