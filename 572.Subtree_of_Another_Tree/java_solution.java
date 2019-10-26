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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(t==null) return true;
        if(s==null) return s==t;
        if(sameTree(s,t)) return true;
        if(isSubtree(s.left,t)) return true;
        if(isSubtree(s.right,t)) return true;
        return false;
    }
    private boolean sameTree(TreeNode s, TreeNode t){
        if(s==null||t==null) return s==t;
        if(s.val!=t.val) return false;
        return(sameTree(s.left,t.left)&&sameTree(s.right,t.right));
    }
}
