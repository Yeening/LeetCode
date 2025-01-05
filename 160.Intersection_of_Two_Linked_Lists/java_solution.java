/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        while(p1 != p2){
            if(p1 == null){
                p1 = headB;
            }
            else{
                p1 = p1.next;
            }
            if(p2 == null){
                p2 = headA;
            }
            else{
                p2 = p2.next;
            }
        }
        return p1;
    }
}

// Solution 2
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<>();
        ListNode p1 = headA, p2 = headB;
        while (p1 != null && p2 != null) {
            if (p1 == p2) {
                // equal length
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        if (p2 == null) {
            ListNode temp = headA;
            headA = headB;
            headB = temp;
            p2 = p1;
        }

        // A is shorter than B
        while (p2 != null) {
            p2 = p2.next;
            headB = headB.next;
        }

        while (headA != null) {
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }
}
