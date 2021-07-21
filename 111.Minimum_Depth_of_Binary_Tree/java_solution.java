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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        int depth = 1;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0 ; i < size; i++) {
                TreeNode cur = deque.pollFirst();
                if (cur.left == null && cur.right == null) {
                    return depth;
                } 
                if (cur.left != null) {
                    deque.addLast(cur.left);
                } 
                if (cur.right != null) {
                    deque.addLast(cur.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
