package LinkedList;

public class LC369_Plus_One_Linked_List {
    public ListNode plusOne(ListNode head) {
        if (head == null) return null;
        ListNode newHead = reverse(head);
        ListNode cur = newHead;
        int carry = 1;
        while (cur != null) {
            int sum = cur.val + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            cur = cur.next;
        }
        if (carry != 0) {
            head.next = new ListNode(carry);//这里cur==null所以不能用cur.next链接
        }
        return reverse(newHead);
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
