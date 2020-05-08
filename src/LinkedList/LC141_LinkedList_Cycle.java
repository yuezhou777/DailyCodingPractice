package LinkedList;

public class LC141_LinkedList_Cycle {
    //S1: HashSet: O(n), O(n)
    //S2: Class with visited field: O(n), revise ListNode class
    //S3: 2 pointers: O(n), O(1)
    public boolean detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    //different from find middle -> distance middle vs ListNodes middle
    //另外为了防止两倍关系之后，偶数个情况下，slow停止的位置不是中间偏左而是中间偏右的问题
    public ListNode findMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
