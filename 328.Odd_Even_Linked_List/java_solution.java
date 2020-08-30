/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode oddHead = head, evenHead = head.next;
        ListNode p1 = oddHead, p2 = evenHead;
        while(p1.next != null && p2.next != null){
            p1.next = p1.next.next;
            p2.next = p2.next.next;
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = evenHead;
        return oddHead;
    }
}
