package LinkedList;

public class LC19_Remove_Nth_Node_From_End_of_List {
    //有没有可能删掉头？dummy
    //one-pass: slow fast, fast先走n步
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        ListNode slow = dummy;
        ListNode fast = dummy;
        dummy.next = head;
        for (int i = 0; i < n; i++) { //Given n will always be valid.
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
