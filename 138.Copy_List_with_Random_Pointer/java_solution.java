/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
//Solution1: O(N) space
// class Solution {
//     public Node copyRandomList(Node head) {
//         if(head==null) return head;
//         Node head2 = new Node(head.val);
//         Node p1 = head, p2 = head2;
//         Map<Node, Node> addressMap = new HashMap<>();
//         addressMap.put(head, head2);
//         while(p1.next!=null){
//             p2.next = new Node(p1.next.val);
//             addressMap.put(p1.next, p2.next);
//             p1 = p1.next;
//             p2 = p2.next;
//         }
//         p1 = head;
//         p2 = head2;
//         while(p1!=null){
//             p2.random = addressMap.get(p1.random);
//             p1 = p1.next;
//             p2 = p2.next;
//         }
//         return head2;
//     }
// }

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return head;
        Node p = head;
        //First round A->A'->B->B'
        while(p!=null){
            Node newNode = new Node(p.val);
            newNode.next = p.next;
            p.next = newNode;
            p = newNode.next;
        }
        //Second round, copy random pointer
        p = head;
        while(p!=null){
            if(p.random!=null) p.next.random = p.random.next;
            else p.next.random = null;
            p = p.next.next;
        }
        //Third round, recover lists
        p = head;
        Node head2 = head.next;
        while(p.next!=null){
            Node next = p.next;
            p.next = p.next.next;
            p = next;
        }
        return head2;
    }
}
