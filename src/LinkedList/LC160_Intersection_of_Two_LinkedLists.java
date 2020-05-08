package LinkedList;

public class LC160_Intersection_of_Two_LinkedLists {
    //S1: HashSet: O(n), O(n)

    //S2: Math solution:
    //Use 2 pointers pA and pB, let then traverse through the list one node at a time
    //When pA reaches the end of listA, redirect it to the head of B, similarly for pB
    //O(m + n) O(!)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pointA = headA;
        ListNode pointB = headB;
        while (pointA != pointB) {
            pointA = (pointA == null) ? headB : pointA.next;
            pointB = (pointB == null) ? headA : pointB.next;
        }

        return pointA;
    }

    //S3: Intuitive solution: calculate difference between lengthA and lengthB, and use 2 pointers. if lenA > lenB,
    // let pointerA goes first k steps(k is the difference), and pointer A, B goes together until meet
    // vice versa
    // O(3 * max(m, n)) O(1)
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode cur = headA;
        int lenA = 0;
        while (cur != null) {
            cur = cur.next;
            lenA++;
        }
        cur = headB;
        int lenB = 0;
        while (cur != null) {
            cur = cur.next;
            lenB++;
        }

        ListNode curA = headA;
        ListNode curB = headB;
        if (lenA >= lenB) {
            int diff = lenA - lenB;
            for (int i = 0; i < diff; i++) {
                curA = curA.next;
            }
            while (curA != null && curB != null) {
                if (curA == curB) {
                    return curA;
                }
                curA = curA.next;
                curB = curB.next;
            }
        } else {
            int diff = lenB - lenA;
            for (int i = 0; i < diff; i++) {
                curB = curB.next;
            }
            while (curA != null && curB != null) {
                if (curA == curB) {
                    return curA;
                }
                curA = curA.next;
                curB = curB.next;
            }
        }

        return null;
    }
}
