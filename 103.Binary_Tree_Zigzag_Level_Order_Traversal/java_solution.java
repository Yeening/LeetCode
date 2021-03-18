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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        boolean RTL = false;
        while (!queue.isEmpty()) {
            LinkedList<Integer> level = new LinkedList<>();
            int size = queue.size();
            for (int i = 0 ; i < size; i++) {
                TreeNode cur = queue.poll();
                if (RTL) level.addFirst(cur.val);
                else level.addLast(cur.val);
                if(cur.left != null) queue.add(cur.left);
                if(cur.right!= null) queue.add(cur.right);
            }
            res.add(level);
            RTL = !RTL;
        }
        return res;
    }
}
