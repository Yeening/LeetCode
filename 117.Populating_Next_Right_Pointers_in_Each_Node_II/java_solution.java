/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

// level order traverse, iterative
class Solution {
    public Node connect(Node root) {
        if (root == null) {return null;}
        Node prev = null, nextLevelStart = null, cur = root;
        while (cur != null) { // 2
            if (cur.left != null) {
                if (prev != null) {
                    prev.next = cur.left;
                } else {
                    nextLevelStart = cur.left; // 2
                }
                prev = cur.left; // 2
            }
            
            if (cur.right != null) {
                if (prev != null) {
                    prev.next = cur.right;
                } else {
                    nextLevelStart = cur.right;
                }
                prev = cur.right;
            }
            
            if (cur.next != null) {
                cur = cur.next;
            } else {
                cur = nextLevelStart;
                prev = null;
                nextLevelStart = null;
            }
            
        }
        return root;
    }
}

// level order traverse, iterative 
class Solution {
    Set<Node> visited = new HashSet<>();
    public Node connect(Node root) {
        if (root == null) {return null;}
        if (visited.contains(root)) {return root;}
        visited.add(root);
        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else {
                root.left.next = findNextLevelLeft(root.next);
            }
        }
        if (root.right != null) {
            root.right.next = findNextLevelLeft(root.next);
        }
        connect(root.next);
        connect(root.left);
        connect(root.right);
        return root;
    }
    
    
    private Node findNextLevelLeft(Node root) {
        while (root != null) {
            if (root.left != null) {
                return root.left;
            } else if (root.right != null) {
                return root.right;
            } else {
                root = root.next;
            }
        }
        return null;
    }
}
