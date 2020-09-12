/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||inorder==null||preorder.length==0||inorder.length==0){
            return null;
        }
        return helper(preorder, 0, inorder, 0, inorder.length-1);
    }
    
    private TreeNode helper(int[] preorder, int preLo, int[] inorder, int inLo, int inHi){
        if(inLo > inHi) return null;
        int rootVal = preorder[preLo];
        TreeNode root = new TreeNode(rootVal);
        for(int i = inLo; i <= inHi; i++){
            if(inorder[i] == rootVal){
                root.left = helper(preorder, preLo+1, inorder, inLo, i-1);
                root.right = helper(preorder, preLo+(i-inLo)+1, inorder, i+1, inHi);
                return root;
            }
        }
        return null;
    }
}
