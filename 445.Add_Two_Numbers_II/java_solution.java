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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.val == 0) {return l2;}
        if (l2.val == 0) {return l1;}
        Deque<Integer> stack1 = new ArrayDeque<>(), 
            stack2 = new ArrayDeque<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int additional = 0;
        ListNode head = null;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int val = additional;
            if (!stack1.isEmpty()) {val += stack1.pop();}
            if (!stack2.isEmpty()) {val += stack2.pop();}
            if (val > 9) {
                additional = 1;
                val -= 10;
            } else {
                additional = 0;
            }
            ListNode newHead = new ListNode(val, head);
            head = newHead;
        }
        if (additional > 0) {
            head = new ListNode(1, head);
        }
        return head;
    }
}
