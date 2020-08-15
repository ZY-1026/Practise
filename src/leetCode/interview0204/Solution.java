package leetCode.interview0204;


/**
 * 编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。
 * 如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。
 * 分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。
 * <p>
 * 示例:
 * <p>
 * 输入: head = 3->5->8->5->10->2->1, x = 5
 * 输出: 3->1->2->10->5->5->8
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode preHead = new ListNode(-1);
        ListNode nextHead = new ListNode(-1);
        ListNode preCurrent = preHead, nextCurrent = nextHead, current = head;
        while (current != null) {
            if (current.val < x) {
                preCurrent.next = current;
                preCurrent = preCurrent.next;
            } else {
                nextCurrent.next = current;
                nextCurrent = nextCurrent.next;
            }
            current = current.next;
        }
        preCurrent.next = nextHead.next;
        nextCurrent.next = null;
        return preHead.next;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
