class Solution {
    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        visit(root);
        return root;
    }
    
    private void visit(TreeNode root) {
        if (root == null) return;
        visit(root.right);
        sum += root.val;
        root.val = sum;
        visit(root.left);
    }
}
