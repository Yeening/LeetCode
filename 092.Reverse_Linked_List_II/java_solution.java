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

// Recursive solution 
// explaination: https://labuladong.gitbook.io/algo/mu-lu-ye-1/mu-lu-ye/di-gui-fan-zhuan-lian-biao-de-yi-bu-fen
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) return reverseFirstN(head, right);
        head.next =  reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    public ListNode reverseFirstN(ListNode head, int n) {
        if (n <= 1) return head;
        ListNode last = reverseFirstN(head.next, n - 1);
        ListNode successor = head.next.next;
        head.next.next = head;
        head.next = successor;
        return last;
    }
}
