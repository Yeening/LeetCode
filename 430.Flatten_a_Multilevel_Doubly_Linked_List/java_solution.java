// solution 1: iterative
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node cur = head;
        while (cur != null) {
            if (cur.child != null) {
                Node next = cur.next;
                cur.next = cur.child;
                cur.child.prev = cur;
                cur.child = null;
                // find tail of child
                Node temp = cur.next;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = next;
                if (next != null) {next.prev = temp;}
               
            }
            // go to next / next level
            cur = cur.next;
        }
        return head;
    }    
}

// solution 2: recursive
class Solution {
    public Node flatten(Node head) {
        flattenTail(head);
        return head;
    }
    
    private Node flattenTail(Node node) {
        if (node == null) {return null;}
        Node tail = node;
        while (node != null) {
            if (node.child != null) {
                Node next = node.next;
                node.next = node.child;
                node.child.prev = node;
                Node nextTail = flattenTail(node.child);
                nextTail.next = next;
                if (next != null) {next.prev = nextTail;}
                node.child = null;
            }
            tail = node;
            node = node.next;
        }
        return tail;
    }
}
