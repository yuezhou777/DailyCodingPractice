package LinkedList;

/*
* Given 1->2->3->4, you should return the list as 2->1->4->3.
* */
public class LC24_Swap_Nodes_in_Pairs {
    //Recursion
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }
}
