/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int maxValue;
    public int maxPathSum(TreeNode root) {
        if(root==null) return -1;
        maxValue = root.val;
        maxDownValue(root);
        return maxValue;
    }
    private int maxDownValue(TreeNode current){
        if(current==null) return 0;
        int left = Math.max(0, maxDownValue(current.left));
        int right = Math.max(0, maxDownValue(current.right));
        maxValue = Math.max(maxValue, current.val+left+right);
        return current.val + Math.max(left, right);
    }
}
