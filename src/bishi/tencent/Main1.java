package bishi.tencent;

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        this.val = x;
    }
}

public class Main1 {
    private static ListNode delete(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode one = dummy, two = dummy;
        for (int i = 0; i <= n; i++) {
            one = one.next;
        }
        while (one != null) {
            one = one.next;
            two = two.next;
        }
        two.next = two.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        Scanner sc = new Scanner(System.in);
        String[] tmpNum = sc.nextLine().split(" ");
        int n = Integer.valueOf(tmpNum[0]);
        int k = Integer.valueOf(tmpNum[1]);
        ListNode cur = head;
        String[] strings = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            int val = Integer.valueOf(strings[i]);
            cur.next = new ListNode(val);
            cur = cur.next;
        }
        ListNode result = delete(head.next, n-k+1);
        while(result!=null){
            if (result.next==null){
                System.out.print(result.val);
            }else {
                System.out.print(result.val + " ");
            }
            result = result.next;
        }
    }
}
