/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 //Iteractive solution
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while(l1!=null || l2!=null){
            if(l1 == null || (l2!=null && l1.val > l2.val)){
                tail.next = l2;
                tail = l2;
                l2 = l2.next;
            }
            else if(l2 == null || (l1!=null&&l1.val <= l2.val)){
                tail.next = l1;
                tail = l1;
                l1 = l1.next;
            }
        }
        return head.next;
    }
}

//Recursice solution
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else{
            l2.next =  mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}


// Solution 3
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode head = new ListNode();
        ListNode p = head;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        p.next = mergeTwoLists(l1, l2);
        return head.next;
        
    }
}
