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
    class ColNode{
        int col;
        TreeNode treeNode;
        ColNode(TreeNode treeNode, int col) {
            this.col = col;
            this.treeNode = treeNode;
        }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {return new ArrayList<>();}
        Map<Integer, List<Integer>> colNodes = new HashMap<>();
        Queue<ColNode> queue = new ArrayDeque<>();
        queue.offer(new ColNode(root, 0));
        int minCol = 0, maxCol = 0;
        while (!queue.isEmpty()) {
            ColNode cur = queue.poll();
            TreeNode node = cur.treeNode;
            colNodes.putIfAbsent(cur.col, new ArrayList<>());
            minCol = Math.min(minCol, cur.col);
            maxCol = Math.max(maxCol, cur.col);
            colNodes.get(cur.col).add(node.val);
            if (node.left != null) {queue.offer(new ColNode(node.left, cur.col - 1));}
            if (node.right != null) {queue.offer(new ColNode(node.right, cur.col + 1));}
        }
        List<List<Integer>> res = new ArrayList<>(colNodes.size());
        for (int j = minCol; j <= maxCol; j++) {
            res.add(colNodes.get(j));
        }
        return res;
    }

}
