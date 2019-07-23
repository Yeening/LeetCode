/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 //Iterative solution
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while(head!=null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}

//Recursive solution
class Solution {
    public ListNode reverseList(ListNode head) {
        return reverseNodeList(head, null);
    }
    public ListNode reverseNodeList(ListNode head, ListNode preHead){
        if(head==null) return preHead;
        ListNode next = head.next;
        head.next = preHead;
        return reverseNodeList(next, head);
    }
}
