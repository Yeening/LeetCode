/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //solution1: Inorder triverse
class Solution {
    int result = 0;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        search(root);
        return result;
    }
    private void search(TreeNode node){
        if(node==null) return;
        search(node.left);
        count--;
        if(count==0) result = node.val;
        search(node.right);
    }
}

// Solution 2 with early return

class Solution {
    private int res = -1;
    private int count = 0;
    private int K = 0;
    public int kthSmallest(TreeNode root, int k) {
        K = k;
        visit(root);
        return res;
    }

    private void visit(TreeNode root) {
        if (root == null || count >= K) return;
        visit(root.left);
        count++;
        if (count == K) {
            res = root.val;
            return;
        }
        visit(root.right);
    }
}
