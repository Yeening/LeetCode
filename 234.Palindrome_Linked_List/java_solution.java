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
 
 // Reverse half of the linked list and then rebuild the input
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head, prev = head;
        if(head==null || head.next==null) return true;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = reverse(slow);
        fast = head;
        while(fast != null && slow != null){
            if(fast.val != slow.val) return false;
            prev = fast;
            fast = fast.next;
            slow = slow.next;
        }
        prev.next = reverse(slow);
        return true;
    }
    private ListNode reverse(ListNode node){
        ListNode prev = null;
        while(node != null){
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
}
