/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//Solution1: 355ms
// class Solution {
//     public ListNode mergeKLists(ListNode[] lists) {
//         ListNode head = new ListNode(-1);
//         ListNode p = head;
//         while(true){
//             int min = Integer.MAX_VALUE, min_index = -1;
//             for(int i = 0; i < lists.length; i++){
//                 if(lists[i]==null) continue;
//                 if(lists[i].val < min){
//                     min = lists[i].val;
//                     min_index = i;
//                 } 
//             }
//             if(min_index<0) return head.next;
//             p.next = new ListNode(min);
//             p = p.next;
//             lists[min_index] = lists[min_index].next;
//         }
//     }
// }

// Priority Queue
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b)->(a.val - b.val));
        for(int i = 0; i < lists.length; i++) {
            if(lists[i] != null) {
                queue.add(lists[i]);
            }
        }
        ListNode head = new ListNode();
        ListNode p = head;
        while (!queue.isEmpty()) {
            p.next = queue.poll();
            if (p.next.next != null) {
                queue.add(p.next.next);
            }
            p = p.next;
        }
        return head.next;
    }
}


//Solution2, using recursion, 3ms 85%
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        return partition(lists, 0, lists.length-1);
    }
    private ListNode partition(ListNode[] lists, int lo, int hi){
        if(lo==hi) return lists[lo];
        int mid = (lo+hi)/2;
        ListNode left = partition(lists,lo, mid);
        ListNode right = partition(lists, mid+1, hi);
        return mergeTwo(left, right);
    }
    private ListNode mergeTwo(ListNode n1, ListNode n2){
        if(n1==null) return n2;
        if(n2==null) return n1;
        if(n1.val<n2.val){
            n1.next = mergeTwo(n1.next, n2);
            return n1;
        }
        else{
            n2.next = mergeTwo(n1, n2.next);
            return n2;
        }
    }
}
