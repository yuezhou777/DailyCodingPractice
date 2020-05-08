package LinkedList;

/*
* Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

    Input: 1->2->3->3->4->4->5
    Output: 1->2->5

* */
public class LC82_Remove_Duplicates_from_Sorted_List_II {
    //与83题不同在于：移除全部重复，不能指针站肩，需要记录重复元素的前一个 -> pre, cur
    // head重复怎么办 -> dummy;
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;

        while (pre.next != null && pre.next.next != null) {
            if (pre.next != null && pre.next.val == pre.next.next.val) {
                int duplicateVal = pre.next.val; //如果这里不存，pre就走到pre.next，重复元素就会被留下来一个
                while (pre.next != null && pre.next.val == duplicateVal) {
                    pre.next = pre.next.next;
                }
            } else {
                pre = pre.next;
            }
        }

        return dummy.next;
    }
}
