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

// Iterative solution
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return head;
        ListNode before = new ListNode(0, head), after = null,
        l = head, r = null;
        for (int i = 0; i < left - 1; i++){
            l = l.next;
            before = before.next;
        }
        r = l;
        for (int i = left; i < right; i++) {
            r = r.next;
        }
        after = r.next;

        // reverse [left, right]
        ListNode pre = before, cur = l;
        while (cur != after) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        before.next.next = after;
        before.next = pre;
        // If left is 1, head will not point to the right node
        if (left > 1) {
            return head;
        } else {
            return before.next;
        }
    }
}
