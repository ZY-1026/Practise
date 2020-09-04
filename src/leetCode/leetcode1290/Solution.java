package leetCode.leetcode1290;

import leetCode.utils.ListNode;

public class Solution {
    public int getDecimalValue(ListNode head) {
        int length = 0;
        ListNode cur = head;
        for (; cur != null; cur = cur.next) {
            length++;
        }
        int result = 0;
        ListNode pre = head;
        while (pre != null) {
            int val = pre.val;
            result += Math.pow(2, length - 1) * val;
            length--;
            pre = pre.next;
        }
        return result;
    }
}
