//Recursion, setting 2 boundaries for each check, beats 100%
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isBST(root.left, (long)Integer.MIN_VALUE - 1, root.val) &&
            isBST(root.right, root.val, (long)Integer.MAX_VALUE + 1);
    }
    
    private boolean isBST(TreeNode node, long lowerBund, long upperBund){
        if(node == null) return true;
        if(node.val <= lowerBund || node.val >= upperBund) return false;
        return(isBST(node.left, lowerBund, node.val) && 
              isBST(node.right, node.val, upperBund));
    }
}
