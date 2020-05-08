package LinkedList;

public class LC142_LinkedList_Cycle_II {
    //S1: HashSet: O(n), O(n)
    //S2: Class with visited field: O(n), revise ListNode class
    //S3: 2 pointers: O(n), O(1)
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null;
    }
}
