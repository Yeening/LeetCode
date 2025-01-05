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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode prev = head, p1 = prev.next;
        while (p1 != null) {
            if (p1.val != prev.val) {
                prev.next = p1;
                prev = p1;
            }
            p1 = p1.next;
        }
        prev.next = null;
        return head;
    }
}
