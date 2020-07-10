package LinkedList;

public class LC148_Sort_List {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = head;
        ListNode mid = findMid(head);
        ListNode post = mid.next;
        mid.next = null;
        pre = sortList(head);
        post = sortList(post);
        return merge(pre, post);
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) { return l2;}
        if (l2 == null) { return l1;}
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
}
