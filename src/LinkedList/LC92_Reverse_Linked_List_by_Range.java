package LinkedList;

/*
    1 ≤ m ≤ n ≤ length of list.

    1->2->3->4->5->6
          m     n
       p  c
*/
public class LC92_Reverse_Linked_List_by_Range {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        //cc
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;
        for (int i = 0; i < m - 1; i++) {
            pre = cur;
            cur = cur.next;
        }

        if (pre != null) { //注意：如果用到 .next 就要想到null //m = 1的情况
            pre.next = reverse(cur, n - m + 1);
            return head;
        } else {
            return reverse(head, n - m + 1);
        }
    }

    private ListNode reverse (ListNode head, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        for (int i = 0; i < n; i++) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        head.next = cur;

        return pre;
    }

}
