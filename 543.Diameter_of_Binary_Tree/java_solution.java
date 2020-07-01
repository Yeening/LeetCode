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
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        longestBranch(root);
        return diameter - 1;
    }
    private int longestBranch(TreeNode root){
        if(root == null) return 0;
        int leftBranch = longestBranch(root.left), rightBranch = longestBranch(root.right);
        diameter = Math.max(diameter, leftBranch + 1 + rightBranch);
        return Math.max(leftBranch, rightBranch) + 1;
    }
}
