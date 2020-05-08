package LinkedList;

public class LC237_Delete_Node_in_a_LinkedList {
    public void deleteNode(ListNode node) {
        if (node == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
