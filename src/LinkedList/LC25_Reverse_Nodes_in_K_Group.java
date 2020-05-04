package LinkedList;

public class LC25_Reverse_Nodes_in_K_Group {
    public ListNode reverseKGroup(ListNode head, int k) {
        //clarify：left-out nodes less than k should remain as it is

        //base case
        if (head == null) return head;

        ListNode cur = head;
        for (int i = 0; i < k - 1; i++) {
            cur = cur.next;
            if (cur == null) {
                return head; //less than k
            }
        }

        ListNode post = cur.next;
        cur.next = null;
        ListNode newHead = reverse(head);
        head.next = reverseKGroup(post, k);
        return newHead;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null; //没有这一步的话1->2->3时1的next就不会指向空
        return newHead;
    }
}
