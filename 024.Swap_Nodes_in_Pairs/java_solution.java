/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 
-1 1  2   
p  c  n   nn
 */

// iterative
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {return head;}
        ListNode preHead = new ListNode(-1, head);
        ListNode prev = preHead, cur = head, next = head.next, 
            nextNext = head.next.next;
        while (cur != null && next != null) {
            prev.next = next;
            cur.next = nextNext;
            next.next = cur;
            cur = nextNext;
            if (cur != null) {next = cur.next;}
            if (next != null) {nextNext = next.next;}
            prev = prev.next.next;
        }
        
        return preHead.next;
    }
}

// recursive
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {return head;}
        ListNode preHead = new ListNode(-1, head);
        ListNode prev = preHead, cur = head, next = head.next;
        prev.next = next;
        cur.next = swapPairs(next.next);
        next.next = cur;
        return preHead.next;
    }
}
