class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode successor = findSuccessor(root.right);
            root.right = deleteNode(root.right, successor.val);
            root.val = successor.val;
        }
        return root;
    }
    private TreeNode findSuccessor(TreeNode root) {
        // find smallest in right sub-tree
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
