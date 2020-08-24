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
    public int rob(TreeNode root) {
        int[] rootGain = robGain(root);
        return Math.max(rootGain[0], rootGain[1]);
    }
    
    private int[] robGain(TreeNode node){
        // return [robGain, nonRobGain] of a node
        if(node == null) return new int[] {0, 0};
        int[] leftGain = robGain(node.left);
        int[] rightGain = robGain(node.right);
        return new int[] {node.val + leftGain[1] + rightGain[1],
               Math.max(leftGain[0], leftGain[1]) + Math.max(rightGain[0], rightGain[1])};
    }
}
