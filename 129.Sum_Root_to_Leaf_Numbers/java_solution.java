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
    int res = 0;
    public int sumNumbers(TreeNode root) {
        sum(root, 0);
        return res;
    }

    private void sum(TreeNode node, int num) {
        if (node == null) return;
        num = num * 10 + node.val;
        if (node.left == null && node.right == null) {
            res += num;
        }
        sum(node.left, num);
        sum(node.right, num);
    }
}
