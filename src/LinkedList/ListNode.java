package LinkedList;

public class ListNode {
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
/*
    public class ListNode<T> {
        int val;
        ListNode<T> next;
        ListNode<T> prev;

        ListNode(){
            this(0)
        }
        ListNode(T val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }
*/
