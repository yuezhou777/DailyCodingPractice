package LinkedList;

public class LC707_Design_LinkedList {
    class MyLinkedList { //to do: generic
        private ListNode head;
        private ListNode tail;
        int size;

        /** Initialize your data structure here. */
        public MyLinkedList() {
            head = null;
            tail = null;
            size = 0;
        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            if (head == null || index < 0 || index >= size) return -1;
            ListNode cur = head;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
            return cur.val;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            ListNode newHead = new ListNode(val);
            if (head == null) {
                tail = newHead;
            } else {
                newHead.next = head;
                head.pre = newHead;
            }
            head = newHead;
            size++;
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            ListNode newTail = new ListNode(val);
            if (tail == null) {
                head = newTail;
            } else {
                tail.next = newTail;
                newTail.pre = tail;
            }
            tail = newTail;
            size++;
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            if (index == 0) {
                addAtHead(val);
                return;
            }
            if (index == size) {
                addAtTail(val);
                return;
            }
            if (index > size) return;
            ListNode cur = head;
            for (int i = 0; i < index - 1; i++) { //前一个
                cur = cur.next;
            }
            ListNode insNode = new ListNode(val);
            ListNode post = cur.next;
            cur.next = insNode;
            insNode.pre = cur;
            post.pre = insNode;
            insNode.next = post;
            size++;
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) return;
            if (head == tail) {
                head = null;
                tail = null;
            } else if (index == 0) {
                ListNode post = head.next;
                post.pre = null;
                head = post;
            } else if (index == size - 1) {
                ListNode prev = tail.pre;
                prev.next = null;
                tail = prev;
            } else {
                ListNode cur = head;
            /* suggestion
            int idx = 0;
            while(idx!=index){
                cur = cur.next;
                idx+=1;
            }*/
                for (int i = 0; i < index; i++) { //本身
                    cur = cur.next;
                }
                ListNode next = cur.next;
                ListNode prev = cur.pre;
                prev.next = next;
                next.pre = prev;
            }
            size--;
        }
    }

    class ListNode {
        ListNode pre;
        ListNode next;
        int val;
        ListNode (int val) {
            pre = null;
            next = null;
            this.val = val;
        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
}
