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
class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return head;
        Node head2 = new Node(head.val);
        Node p1 = head, p2 = head2;
        Map<Node, Node> addressMap = new HashMap<>();
        addressMap.put(head, head2);
        while(p1.next!=null){
            p2.next = new Node(p1.next.val);
            addressMap.put(p1.next, p2.next);
            p1 = p1.next;
            p2 = p2.next;
        }
        p1 = head;
        p2 = head2;
        while(p1!=null){
            p2.random = addressMap.get(p1.random);
            p1 = p1.next;
            p2 = p2.next;
        }
        return head2;
    }
}
